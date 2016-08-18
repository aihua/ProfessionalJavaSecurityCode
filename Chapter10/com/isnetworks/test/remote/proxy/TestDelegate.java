
/**
 * TestDelegate.java
 *
 *
 * Created: Tue Feb  1 16:49:38 2000
 *
 * @author Daniel R. Somerfield
 * @version 1.0
 */

package com.isnetworks.test.remote.proxy;
/**
 * A simple class to test the object delegation
 */
public class TestDelegate implements Test {
	
	public String getMessage(String name){
		return "Hello " + name + ".";
	}
}
