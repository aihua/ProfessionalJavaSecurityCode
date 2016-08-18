
/**
 * Debug.java
 *
 *
 * Created: Tue Feb  1 18:58:53 2000
 *
 * @author Daniel R. Somerfield
 * @version 1.0
 */
package com.isnetworks.util;
/**
 * A collection of static methods useful for debugging
 */
import java.io.*;
import java.lang.reflect.*;
public class Debug  {
	
	/**
	 * Prints arrays
	 */
	public static String getArrayAsString(Object array){
		
		if (array==null){
			return null;
		}

		if (!array.getClass().isArray()){
			return array.toString();
		}
		
		StringBuffer buffer = new StringBuffer();
		int length = Array.getLength(array);
		Object obj;
		for (int x=0; x<length; x++){
			obj = Array.get(array, x);
			if (obj.getClass().isArray()){
				buffer.append(getArrayAsString(obj) + "\n");
			}else{
				buffer.append(obj.toString() + " | " );
			}
		}
		return buffer.toString();

	}

	/**
	 * Return the stack trace as a string
	 */
	public static String getStackTraceAsString(Throwable e){
		if ( e == null ) {
			return "";
		}
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintWriter writer = new PrintWriter(stream);
		e.printStackTrace(writer);
		writer.flush();
		return stream.toString();
	}
	
}
