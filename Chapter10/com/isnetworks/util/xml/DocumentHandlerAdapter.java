
/**
 * DocumentHandlerAdapter.java
 *
 * @author Daniel R. Somerfield
 * @version 1.0
 */
package com.isnetworks.util.xml;
/**
 * A utility class that implements
 */
import org.xml.sax.DocumentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.AttributeList;
import org.xml.sax.Locator;
public abstract class DocumentHandlerAdapter 
	implements DocumentHandler  {
	
	public void setDocumentLocator(Locator locator) {}

	public void startDocument() throws SAXException {}

	public void endDocument() throws SAXException {}

	public void startElement(String name, AttributeList attr) 
		throws SAXException {}

	public void endElement(String name) throws SAXException {}
	
	public void characters(char[] ch, int start, int end) 
		throws SAXException {}

	public void ignorableWhitespace(char[] ch, int start, int end) 
		throws SAXException {}
	
	public void processingInstruction(String target, String data) 
		throws SAXException {}
	
} 
