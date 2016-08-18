/**
 * @(#) OperationProxy.java
 */
package com.isnetworks.remote.proxy;
/**
 * This interface defines the invoke() operation for arbitrarily calling 
 * methods on its target object. This is particularly useful for remote 
 * operations on objects that have interfaces that do not extend Remote.
 *
 * @author Daniel R. Somerfield
 * @version 1.0
 */
import java.lang.reflect.InvocationTargetException;
import java.rmi.*;

public interface OperationProxy extends Remote{

	/**
	 * Invoke the operation with the given arguments.
	 * @param operation the name of the operation to invoke
	 * @param args the args for the operations
	 * @param argClasses the classes according to the method signature
	 * @return the result of the method invocation
	 * @throws java.lang.Exception Forwarded exception from target object
	 */  
	public Object invoke( String operation, Object[] args, 
						  String [] argClasses)
		throws RemoteException, 
		InvocationTargetException, 
		IllegalAccessException,
		NoSuchMethodException,
		ClassNotFoundException;

	/**
	 * Invoke the operation with the given arguments.
	 * @param operation the name of the operation to invoke
	 * @param args the args for the operations
	 * @param argClasses the classes according to the method signature
	 * @param returnClass the proxy class to return
	 * @return the result of the method invocation
	 * @throws java.lang.Exception Forwarded exception from target object
	 */  
	public Object invoke( String operation, Object[] args, 
						  String [] argClasses, Class returnClass)
		throws RemoteException, 
		InvocationTargetException, 
		IllegalAccessException,
		NoSuchMethodException,
		ClassNotFoundException,
		InstantiationException;
	
// 	public void mapProxyClass(Class clazz, Class proxy)
// 		throws RemoteException;
     
}
