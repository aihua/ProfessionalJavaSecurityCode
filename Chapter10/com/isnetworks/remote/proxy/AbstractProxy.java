/**
 * @(#) AbstractProxy.java
 */

package com.isnetworks.remote.proxy;
/**
 * Base class for proxied classes that handles operations such as pluggable
 * interceptors (for things like security) and handling
 * in-process/out-of-process invokes, maybe.
 * @author Daniel R. Somerfield
 * @version 1.0
 */
import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.rmi.server.*;
import com.isnetworks.remote.*;
import com.isnetworks.util.Debug;

public abstract class AbstractProxy implements com.isnetworks.remote.Proxy{

    protected OperationProxy mDelegate;

	/**
	* Invoke the operation on the delegate returning any values from the call to the delegate.
	* @param operation the name of the method to invoke
	* @param args the arguments to pass in to the method
	* @param argClasses the classes of the operations so the the method can be found through introspection
	* @param returnClass the class of the return value. Necessary for operations which need to wrap return values with a Serializable Proxy class.
	*/
    public Object invoke(String operation, Object [] args,
    Class [] argClasses, Class returnClass )
    throws RemoteException,
    InvocationTargetException{

        Object returnValue = null;
        try{

            returnValue = mDelegate.invoke(operation, args,
            getNamesForClasses(argClasses),
            returnClass);
        }catch(InstantiationException e){
            throw new RemoteException("AbstractProxy.invoke() failed with" +
            "the following nested exception.", e);
        }catch(NoSuchMethodException e){
            throw new RemoteException("AbstractProxy.invoke() failed with" +
            "the following nested exception.", e);
        }catch(IllegalAccessException e){
            throw new RemoteException("AbstractProxy.invoke() failed with" +
            "the following nested exception.", e);
        }catch (ClassNotFoundException e){
            throw new RemoteException("AbstractProxy.invoke() failed with" +
            "the following nested exception.", e);
        }


        return returnValue;
    }

    public OperationProxy getOperationProxy(){
        return mDelegate;
    }

    public void setOperationProxy(OperationProxy ops)
    throws RemoteException{
        mDelegate = ops;
    }

    public String [] getNamesForClasses(Class [] cls){
        String [] classNames = null;
        if (cls != null){
            classNames = new String[cls.length];
            for (int x=0; x<cls.length; x++){
                classNames[x] = cls[x].getName();
            }
        }else{
            classNames = new String[0];
        }
        return classNames;
    }

}
