/*
 * InvalidPathException.java
 *
 * Created on April 3, 2000, 12:17 PM
 */

package com.isnetworks.util.xml;
/** 
 * This exception indicats that a parent of the complete XPath did not exist
 * @author  Daniel R. Somerfield
 * @version 1.0
 */
public class InvalidPathException extends Exception {

  /**
   * Creates new <code>InvalidPathException</code> without detail message.
   */
  public InvalidPathException() {
   super();
  }
  

  /**
   * Constructs an <code>InvalidPathException</code> with the specified detail message.
   * @param msg the detail message.
   */
  public InvalidPathException(String msg) {
    super(msg);
  }
}

