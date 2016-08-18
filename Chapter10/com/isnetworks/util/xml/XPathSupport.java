
/**
 * XPathSupport.java
 *
 *
 * Created: Wed Mar 29 12:32:48 2000
 *
 * @author Daniel R. Somerfield
 * @version 1.0
 */
package com.isnetworks.util.xml;

/**
 * A class of utility methods for rudimentary partial XPath support
 */
import java.util.*;
public class XPathSupport  {

  /**
   * Get the child of this parent. This method only gets the
   * immediate children of the parent.
   */
  public static Collection getChildrenFromNode (XMLPropertyNode parent,
  String simplePath){

    int startIndex = simplePath.indexOf('[');
    int endIndex = simplePath.indexOf(']');
    if (startIndex == -1 || endIndex == -1){
      //No attribute or index specified, return based on name
      return parent.getChildren(simplePath);
    }

    String filterString = simplePath.substring(startIndex + 1, endIndex);
    String name = simplePath.substring(0, startIndex);

    //Figure out if it is an index or an attribute filter
    if (filterString.charAt(0) == '@'){
      //Its an attribute check if there is a value associated with it
      int equalsIndex = filterString.indexOf('=');
      String attrValue = null;
      String attrName = null;

      if (equalsIndex != -1) {
        attrValue = filterString.substring(equalsIndex + 1);
        attrName = stripQuotes(filterString.substring(1, equalsIndex));
      }else{
        attrName = filterString;
      }

      return getChildrenWithAttribute(parent, name, attrName, attrValue);

    }else{
      //It is an index filter
      int index = Integer.parseInt(filterString);
      XMLPropertyNode node = getChildWithIndex(parent, name, index);
      Vector v = new Vector();
      v.addElement(node);
      return v;
    }
  }

  public static XMLPropertyNode getChildWithIndex(XMLPropertyNode parent,
  String name, int index){
    Iterator iter = parent.getChildren(name).iterator();
    XMLPropertyNode node;
    int x =0;
    while (iter.hasNext()){
      node = (XMLPropertyNode)iter.next();
      if (index == x){
        return node;
      }
      x++;
    }
    return null;
  }

  public static Collection getChildrenWithAttribute
  (XMLPropertyNode parent, String name, String attrName, String attrValue){

    //Get the matching children
    Iterator iter = parent.getChildren(name).iterator();
    XMLPropertyNode child;
    Vector v = new Vector();

    while (iter.hasNext()){
      child = (XMLPropertyNode)iter.next();
      if (hasMatchingAttribute(child, attrName, attrValue)){
        v.addElement(child);
      }
    }
    return v;
  }

  public static boolean hasMatchingAttribute(XMLPropertyNode node,
  String name, String value) {

    if (node == null){
      return false;
    }

    Iterator iter = node.getChildren().iterator();
    XMLPropertyNode tmpNode;
    String nodeName;
    String nodeValue;
    while (iter.hasNext()){
      tmpNode = (XMLPropertyNode)iter.next();
      nodeName = tmpNode.getName();
      Object nodeValueObj = tmpNode.getValue();
      if (nodeValueObj != null){
        nodeValue = nodeValueObj.toString();
      }else{
        nodeValue = null;
      }

      if (nodeName.equals(name)){ //Check if the names are equal
        //Check for nulls
        if (value == null){
          if (nodeValue == null){
            return true; //Return true since both are null
          }
        }else{
          //value is not null, so we can safely call value.equals to compare
          if (value.equals(nodeValue)){
            return true;
          }
        }
      }
    }
    return false;
  }

  /**
  * Get the collection of children that match the XPath-style path
  */
  public static Collection getChildrenWithPath(XMLPropertyNode parent,
  String fullPath){

    Vector nodes = new Vector();
    Vector nextNodes;
    StringTokenizer tokenizer = new StringTokenizer (fullPath, "/");
    String simplePath;
    XMLPropertyNode node;
    //String rootName = tokenizer.nextToken();

    //if (rootName.equals(parent.getName())){
      nodes.addElement(parent); //initial seeding of parent
    //} else {
    //  return nodes;
    //}

    while (tokenizer.hasMoreTokens()){
      nextNodes = new Vector();
      simplePath = tokenizer.nextToken();
      for (int x=0; x<nodes.size(); x++){
        node = (XMLPropertyNode)nodes.elementAt(x);
        nextNodes.addAll(getChildrenFromNode(node, simplePath));
      }
      nodes = nextNodes;
    }
    return nodes;
  }

  /**
   *  This returns the first child on the path, creating nodes if they
   *  don't already exist, if specified
   */
  public static XMLPropertyNode getFirstChildWithPath (
  XMLPropertyNode parent, String fullPath, boolean createParents) 
  throws InvalidPathException {
    
    Vector nodes = new Vector();
    StringTokenizer tokenizer = new StringTokenizer (fullPath, "/");
    String simplePath;
    XMLPropertyNode node = parent;
    Collection nextNodes;
    
    while (tokenizer.hasMoreTokens()) {
      simplePath = tokenizer.nextToken();
      nextNodes = getChildrenFromNode(node, simplePath);
      if (nextNodes.isEmpty()) {
        if (createParents || (!tokenizer.hasMoreTokens())) {
          node = createNode(simplePath);
        } else {
          throw new InvalidPathException("The path " + fullPath + 
            "did not exist. The last node reached was " +
            node.toString() + ".");
        }
      } else {
        node = (XMLPropertyNode)nextNodes.iterator().next();
      }
    }
    return node;
  }
  
  public static XMLPropertyNode createNode(String simplePath) {
    int startIndex = simplePath.indexOf('[');
    int endIndex = simplePath.indexOf(']');
    if (startIndex == -1 || endIndex == -1){
      //No attribute or index specified, return based on name
      return new XMLPropertyNode (simplePath);
    } else {
      String name = simplePath.substring(0, startIndex);  
      return new XMLPropertyNode(name);
    }
  }

  /**
  * Strip quotes of strings so equality can be assessed
  */
  public static String stripQuotes(String value){
    int startQuoteIndex = value.indexOf("\"");
    int endQuoteIndex = value.indexOf("\"", startQuoteIndex+1);
    if (startQuoteIndex == -1 || endQuoteIndex == -1){
      return value;
    }else{
      return value.substring(startQuoteIndex + 1, endQuoteIndex);
    }
  }


}

