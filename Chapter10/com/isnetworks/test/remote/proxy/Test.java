
/**
 * Test.java
 *
 *
 * Created: Tue Feb  1 16:55:23 2000
 *
 * @author Daniel R. Somerfield 
 * @version 1.0
 */
package com.isnetworks.test.remote.proxy;
/**
 * This interface is an example of what interface could be exposed that
 * the programmer doesn't have access to the underlying implementation.
 * Therefore, he/she is forced to proxy it in order to ensure that remote
 * operations will work.
 */
public interface Test {
	
	public String getMessage(String name);

}
