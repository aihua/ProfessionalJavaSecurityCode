
/**
 * ConfigurationException.java
 *
 *
 * Created: Wed Mar  1 09:29:37 2000
 *
 * @author Daniel R. Somerfield
 * @version 1.0
 */
package com.isnetworks.crypto.database.server;
/**
 *
 */
import com.isnetworks.util.NestedException;
public class ConfigurationException extends NestedException {
	
	public ConfigurationException(){
		super();
	}

	public ConfigurationException(String msg){
		super(msg);
	}

	public ConfigurationException(String msg, Throwable e){
		super(msg, e);
	}
  
}
