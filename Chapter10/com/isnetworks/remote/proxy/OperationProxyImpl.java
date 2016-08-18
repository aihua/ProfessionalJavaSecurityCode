/**
 * @(#) OperationProxyImpl.java
 */

package com.isnetworks.remote.proxy;
/**
 * @author Daniel R. Somerfield
 * @version 1.0
 */
import java.lang.reflect.*;
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
import com.isnetworks.util.Debug;
import com.isnetworks.remote.proxy.*;

public class OperationProxyImpl extends UnicastRemoteObject
implements OperationProxy{

    /**
     * The actual object which does the operations in question
     */
    private Object mTarget;

    /**
     * The mappings of classes to their proxies
     */
    private Hashtable mProxyMap = new Hashtable();

    /**
     * Default constructor. Before invoke() is called, a target must be set
     */
    public OperationProxyImpl()
    throws RemoteException{
        super();
    }

    /**
     * Simple constructor except with custom sockets
     * @param port the port to which to connect. If this is 0 an anonymous
     * port is used.
     * @param clientFactory the custom factory for client sockets
     * @param serverFactory the custom factory for server sockets
     */
    public OperationProxyImpl(RMIClientSocketFactory clientFactory,
    RMIServerSocketFactory serverFactory)
    throws RemoteException{
        super(0, clientFactory, serverFactory);
    }

    /**
     * Constructor with a provided target. Allows invoke() to be
     * called immediately after construction
     * @param target the target for the called operations
     */
    public OperationProxyImpl (Object target)
    throws RemoteException{
        this();
        setTarget(target);
    }

    /**
     * Constructor with a provided target and custome sockets. Allows invoke()
     * to be called immediately after construction
     * @param target the target for the called operations
     * @param clientFactory the custom factory for client sockets
     * @param serverFactory the custom factory for server sockets
     */
    public OperationProxyImpl(Object target,
    RMIClientSocketFactory clientFactory,
    RMIServerSocketFactory serverFactory)
    throws RemoteException{
        super(0, clientFactory, serverFactory);
        setTarget(target);
    }

    /**
     * Set the target for this instance. This is most useful for
     * pools. It may be necessary to change the target if something
     * like pooled connections are being proxied.
     * @param target the new target object for operations
     */
    public void setTarget(Object target){
        mTarget = target;
    }

    public void mapProxyClass(Class clazz, Class proxy){
        mProxyMap.put(clazz, proxy);
    }

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
    InstantiationException{
        if (returnClass == null){
            return invoke(operation, args, argClasses);
        }

        Class clazz = mTarget.getClass();
        Method method = clazz.getMethod(operation,
        getClassesForNames(argClasses));
        Object returnObject = method.invoke(mTarget, args);
        //Add in check for custom proxies here
        AbstractProxy proxy = (AbstractProxy)returnClass.newInstance();
        OperationProxyImpl opProxy = new OperationProxyImpl(returnObject);
        proxy.setOperationProxy(opProxy);
        return proxy;

    }

    /**
     * Invoke the operation with the given arguments. This method should only
     * be called when there is a serializable object being returned.
     * @param operation the name of the operation to invoke
     * @param args the args for the operations
     * @param argClasses the classes of the arguments
     * @return the result of the method invocation
     * @throws java.lang.Exception Forwarded exception from target object
     */
    public Object invoke( String operation, Object[] args,
    String [] argClasses)
    throws InvocationTargetException,
    IllegalAccessException,
    NoSuchMethodException,
    RemoteException,
    ClassNotFoundException{

        Class clazz = mTarget.getClass();
        Method method = clazz.getMethod(operation, getClassesForNames
        (argClasses));
        Object returnObject = method.invoke(mTarget, args);

        return returnObject;
    }

    /**
     * Gets the classes for each class name. This is necessary because of
     * a bug in JDK1.2 which doesn't serialize primitive classes correctly
     */
    public Class [] getClassesForNames(String [] classNames)
    throws ClassNotFoundException{
        if (classNames != null){
            Class [] returnClasses = new Class[classNames.length];
            for (int x=0; x<classNames.length; x++){
                if (classNames[x].equals("boolean")){
                    returnClasses[x] = java.lang.Boolean.TYPE;
                }else if (classNames[x].equals("byte")){
                    returnClasses[x] = java.lang.Byte.TYPE;
                }else if (classNames[x].equals("char")){
                    returnClasses[x] = java.lang.Character.TYPE;
                }else if (classNames[x].equals("double")){
                    returnClasses[x] = java.lang.Double.TYPE;
                }else if (classNames[x].equals("float")){
                    returnClasses[x] = java.lang.Float.TYPE;
                }else if (classNames[x].equals("int")){
                    returnClasses[x] = java.lang.Integer.TYPE;
                }else if (classNames[x].equals("long")){
                    returnClasses[x] = java.lang.Long.TYPE;
                }else if (classNames[x].equals("short")){
                    returnClasses[x] = java.lang.Short.TYPE;
                }else{
                    returnClasses[x] = Class.forName(classNames[x]);
                }
            }
            return returnClasses;
        }else{
            return null;
        }
    }

}
