
/**
 * XMLParsingException.java
 *
 *
 * Created: Fri Mar 24 15:37:59 2000
 *
 * @author Daniel R. Somerfield
 * @version 1.0
 */
package com.isnetworks.util.xml;
/**
 * A wrapper exception for any kind of failure to parse
 */
import com.isnetworks.util.NestedException;
public class XMLParsingException extends NestedException {
	
	public XMLParsingException () {
		super();
	}

	public XMLParsingException (String msg) {
		super(msg);
	}

	public XMLParsingException (String msg, Throwable e) {
		super (msg, e);
	}
	
}
