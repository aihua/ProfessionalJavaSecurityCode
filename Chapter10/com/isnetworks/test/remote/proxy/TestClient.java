
/**
 * TestClient.java
 *
 *
 * Created: Tue Feb  1 18:44:25 2000
 *
 * @author Daniel R. Somerfield
 * @version 1.0
 */
package com.isnetworks.test.remote.proxy;
/**
 * Test proxy
 */
public class TestClient  {
	
	public static void main (String [] args){
		if (args.length < 1){
			usage();
			return;
		}
		String name = args[0];
						   
		Test test = TestServer.createTest();
		System.out.println("The object returned: " + test.getMessage(name));
	}
	
	public static void usage(){
		System.err.println("usage: java com.isnetworks.test.remote.proxy." +
						   "TestClient <your name>");
	}
}
