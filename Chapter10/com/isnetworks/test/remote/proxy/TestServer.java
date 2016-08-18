
/**
 * TestServer.java
 *
 *
 * Created: Tue Feb  1 17:35:37 2000
 *
 * @author Daniel R. Somerfield
 * @version 1.0
 */
package com.isnetworks.test.remote.proxy;
/**
 * A simple RMI server to make sure that the delegation process
 * works correctly
 */
import java.rmi.*;
import java.rmi.server.*;
import com.isnetworks.remote.proxy.*;

public class TestServer{

	/**
	 * Here is a factory method for getting Test objects.
	 * This isn't really where such a thing would be likely to go,
	 * but whatever.
	 */
	public static Test createTest(){
		return new TestProxy();
	}


	public static void main(String args[]){
		if (System.getSecurityManager()==null){
			System.setSecurityManager(new RMISecurityManager());
		}

		try{
			//Creation of the proxy class with a target. In a real
			//example the target would presumably be bound dynamically
			OperationProxyImpl proxy = new OperationProxyImpl
				(new TestDelegate());
			Naming.rebind("rmi://unagi/test", proxy);
			System.out.println("TestServer: Object bound");

		}catch(Exception e){
			e.printStackTrace();
			System.exit(1);
		}


	}


}
