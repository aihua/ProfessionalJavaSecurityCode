
/**
 * TestProxy.java
 *
 *
 * Created: Tue Feb  1 16:53:37 2000
 *
 * @author Daniel R. Somerfield
 * @version 1.0
 */

package com.isnetworks.test.remote.proxy;
/**
 * Simple proxy to the TestDelegate class
 */
import com.isnetworks.remote.*;
import com.isnetworks.remote.proxy.*;

public class TestProxy extends AbstractProxy implements Test {

	public String getMessage(String name){
		try{
			Object [] args = new Object [1];
			args[0] = name;
			Class [] argClasses = { String.class };
			return (String)invoke("getMessage", args, argClasses, String.class);
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("An error occured: " + e);
		}
	}

	/**
	 * Return the remote name to which to connect. This should not be here,
	 * and should be dynamically configured at some point.
	 */
	public String getRemoteName(){
		return "rmi://unagi/test";
	}


}
