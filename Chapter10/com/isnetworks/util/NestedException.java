
/**
 * NestedException.java
 *
 *
 * Created: Wed Mar  1 09:29:37 2000
 *
 * @author Daniel R. Somerfield
 * @version 1.0
 */

package com.isnetworks.util;
/**
 * An abstract super-class of all exceptions that nest exceptions
 */
public abstract class NestedException extends Exception{	 
	
	protected Throwable mNestedException;
	
	public NestedException() {
		super();
	}
	
	public NestedException(String msg){
		super(msg);
	}

	public NestedException(String msg, Throwable e){
		super(msg);
		mNestedException = e;
	}
	
    public String getMessage() {
        if (mNestedException == null)
            return super.getMessage();
        else
            return super.getMessage() +
                "; nested exception is: \n\t" +
                mNestedException.toString();
    }    


	public void printStackTrace(java.io.PrintStream ps){
        if (mNestedException == null) {
            super.printStackTrace(ps);
        } else {
            synchronized(ps) {
                ps.println(this);
                mNestedException.printStackTrace(ps);
            }
        }
    }

    public void printStackTrace(){
        printStackTrace(System.err);
    }

    public void printStackTrace(java.io.PrintWriter pw){
        if (mNestedException == null) {
            super.printStackTrace(pw);
        } else {
            synchronized(pw) {
                pw.println(this);
                mNestedException.printStackTrace(pw);
            }
        }
    }	
}
