/**
 * @(#) XMLProperties.java
 */

package com.isnetworks.util;

import java.io.*;
import java.util.*;
import org.xml.sax.*;
import org.xml.sax.helpers.ParserFactory;
import com.isnetworks.util.xml.*;
public class XMLProperties {

  public static final String XML_VERSION = "1.0";

  private static final String TAB_SPACING = "  ";

  private Parser mParser;

  private XMLPropertyNode mRoot;

  private String mDTD = "";

  public XMLProperties (){
    super();
  }

  /**
   * Get the property from this XMLProperties X-Path style. A
   * property can be accessed by name or if it is further down the
   * path, you can use this syntax: name1/name2
   */
  public Collection getProperty ( String path ) {
    Collection nodes = XPathSupport.getChildrenWithPath(mRoot, path);
    Iterator iter = nodes.iterator();
    Vector v = new Vector();
    while (iter.hasNext()) {
      XMLPropertyNode node = (XMLPropertyNode)iter.next();
      if (node.isLeaf()) {
        Object value = node.getValue();
        v.addElement(value);
      } else {
        XMLProperties props = new XMLProperties();
        props.mRoot = node;
        v.addElement(props);

      }
    }
    return v;
  }

  /**
   * Return the path to the DTD if one exists
   */
  public String getDTD(){
    return mDTD;
  }

  public void setDTD(String dtd){
    mDTD = dtd;
  }

  public void load(InputStream in)
  throws XMLParsingException, IOException {

    try {
      //Create the parser
      if (mParser == null) {
        String parser = System.getProperty("org.xml.sax.parser");
        if (parser == null) {
          parser = "org.apache.xerces.parsers.SAXParser";
        }
        mParser = ParserFactory.makeParser(parser);
        mParser.setDocumentHandler(new PropertyDocumentHandler());
      }
    }catch(Exception e) {
      throw new  XMLParsingException("XMLProperties.load() failed.", e);
    }

    try {
      InputSource source = new InputSource(in);
      //startRead(source);
      mParser.parse(source);
    } catch (SAXException e){
      throw new  XMLParsingException("XMLProperties.load() failed.", e);
    }

  }

  /**
   * Set a property value, and do not create the path
   */
  public void setProperty( String name, Object value)
  throws InvalidPathException {
    setProperty(name, value, false);
  }

  /**
   * Set a property value
   * @param create if set to true, create all the parent values
   */
  public void setProperty( String name, Object value, boolean create)
  throws InvalidPathException {
    XMLPropertyNode node = XPathSupport.getFirstChildWithPath
    (mRoot, name, create);
    node.setValue(value);
  }

  public void store( OutputStream out )
  throws IOException{
    out.write(("<?xml version=\"" + XML_VERSION + "\"?>\n").getBytes());
    out.write(("<!DOCTYPE " + mRoot.getName() + " SYSTEM \"" + getDTD() +
    "\">\n").getBytes());

    out.write(getNodeAsString(mRoot, 0).getBytes());
  }

  private String getNodeAsString (XMLPropertyNode node, int tabCount)
  throws IOException {
    StringBuffer buffer = new StringBuffer();
    StringBuffer spacing = new StringBuffer();
    for (int x=0; x<tabCount; x++) {
      spacing.append(TAB_SPACING);
    }
    buffer.append(spacing);

    buffer.append("<");
    buffer.append(node.getName());
    Iterator iter = node.getChildren("*").iterator();
    String name;
    XMLPropertyNode n;
    while (iter.hasNext()){
      n = (XMLPropertyNode)iter.next();
      if (n.isAttribute()){
        buffer.append(" ");
        buffer.append(n.getName());
        buffer.append("=\"");
        buffer.append(n.getValue());
        buffer.append("\"");
      }
    }
    buffer.append(">\n");

    iter = node.getChildren("*").iterator();
    while (iter.hasNext()){
      n = (XMLPropertyNode)iter.next();
      if (!n.isAttribute()){
        buffer.append(getNodeAsString(n, tabCount+1));
      }
    }

    //Append the value, if there is one
    Object value = node.getValue();
    if (value != null) {
      buffer.append(spacing);
      buffer.append(TAB_SPACING);
      buffer.append(value.toString());
      buffer.append("\n");
    }

    //Append the closing tag
    buffer.append(spacing);
    buffer.append("</");
    buffer.append(node.getName());
    buffer.append(">\n");
    return buffer.toString();
  }

  /**
   * Check for the version string and DOCTYPE declaration
   */
  private void startRead(InputSource in)
  throws SAXException, IOException{

    Reader reader = in.getCharacterStream();
    char c;

    //Read in and test for the version info
    StringWriter writer = new StringWriter();
    while (((c = (char)reader.read()) != -1) && (c != '>')) {
      writer.write(c);
    }
    String versionString = writer.toString();

  }

  public String toString() {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    try{
      store(out);
    }catch (IOException e) {
      return "XMLProperties - could not display.";
    }
    return new String(out.toByteArray());
  }

  /**
   * This inner-class is responsible for handling the parsing of the
   * XML document and population of the XMLProperties object
   */
  class PropertyDocumentHandler extends DocumentHandlerAdapter {

    /**
     * Stack for document processing
     */
    private Stack mStack = new Stack();

    /**
     * Receive notification of character data
     */
    public void characters (char[] ch, int start, int length)
    throws SAXException{
      XMLPropertyNode node = (XMLPropertyNode)mStack.peek();
      if (node==null) {
        throw new SAXException("Tried to add CDATA to a null node." +
        "Data: " + new String(ch, start, length));
      }else{
        node.setValue(new String(ch, start, length).trim());
      }
    }

    /**
     * Receive notification of the beginning of the document
     */
    public void startDocument ()
    throws SAXException{
      mStack = new Stack();
    }

    /**
     *
     */
    public void endDocument ()
    throws SAXException{
      if (!mStack.empty()){
        Object nodeName = ((XMLPropertyNode)mStack.peek()).getValue();
        throw new SAXException("The documented ended before the " +
        nodeName + " element terminated. ");
      }
    }

    /**
     * Receive notification of the beginning of an element.
     */
    public void startElement (String name, AttributeList atts)
    throws SAXException {
      XMLPropertyNode node;

      //Create the new element
      XMLPropertyNode newNode = new XMLPropertyNode(name);
      XMLPropertyNode attNode;

      //Add the attributes as child elements
      for (int x=0; x<atts.getLength(); x++){
        attNode = new XMLPropertyNode(atts.getName(x));
        attNode.setValue(atts.getValue(x));
        attNode.setAttribute(true);
        newNode.setChild(attNode);
      }

      if (!mStack.empty()){
        node = (XMLPropertyNode)mStack.peek();
        node.setChild(newNode);
        //mRoot = node;
      }else{
        mRoot = newNode;
      }
      mStack.push(newNode);

    }

    /**
     * Receive notification of the end of an element.
     */
    public void endElement (String name)
    throws SAXException{
      XMLPropertyNode node = (XMLPropertyNode)mStack.pop();
      if (!name.equals(node.getName())){
        throw new SAXException("The incorrect element terminated." +
        " The element that should have " +
        "terminated is: " + node.getName() +
        ".\n And the element that did " +
        "terminate: " + name);
      }
    }

  }

  public static void main (String args[]){
    try {
      XMLProperties props = new XMLProperties();
      props.setDTD("http://www.isnetworks.com/SecureDriver_config.dtd");
      props.load(new FileInputStream(args[0]));

      System.out.println("Property: dataSources/dataSource" +
      "[@id=dataSource1]/driver[0]");
      Object value = props.getProperty("dataSources/dataSource" +
      "[@id=dataSource1]/driver[0]")
      .iterator().next();
      System.out.println(value);

      props.setProperty("dataSources/dataSource" +
      "[@id=dataSource1]/driver[0]", "NEW_VALUE");
      props.store(System.out);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }


}