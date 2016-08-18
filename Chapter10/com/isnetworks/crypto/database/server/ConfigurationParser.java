
/**
 * ConfigurationParser.java
 *
 *
 * Created: Wed Mar  1 08:26:32 2000
 *
 * @author Daniel R. Somerfield
 * @version 1.0
 */
package com.isnetworks.crypto.database.server;

import java.io.*;
import org.w3c.dom.*;
import org.xml.sax.*;
//import org.apache.xerces.*;
import org.apache.xerces.parsers.*;

public class ConfigurationParser  {

	private DOMParser mParser;

	public ConfigurationParser() {
          super();
        }

	public Document parseConfigFile(String url)
		throws ConfigurationException{
		try{
			mParser.parse(url);
			return mParser.getDocument();
		}catch(Exception e){
			throw new ConfigurationException("Document parsing failed.", e);
		}
	}
	
}
