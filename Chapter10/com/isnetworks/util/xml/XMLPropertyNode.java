/**
 * @(#) XMLPropertyNode.java
 */

package com.isnetworks.util.xml;
/**
 * A single node in the XMLProperties tree. This can either have another
 * XMLProperties object or any arbitrary other type of object.
 */
import java.util.*;
public class XMLPropertyNode {

  private String mName = null;

  private Object mValue = null;

  private boolean mIsAttribute = false;

  private Vector mChildren = new Vector();

  /**
   * Create an empty node with a name
   */
  public XMLPropertyNode (String name) {
    mName=name;
  }

  public XMLPropertyNode getChild(int index){
    return (XMLPropertyNode)mChildren.elementAt(index);
  }

  public Collection getChildren (String name) {
    if ("*".equals(name)){
      return getChildren();
    }
    Vector v = new Vector();
    XMLPropertyNode node;
    for (int x=0; x< mChildren.size(); x++){
      node = (XMLPropertyNode)mChildren.elementAt(x);
      if (name.equals(node.getName())){
        v.add(node);
      }
    }
    return v;
  }

  public Collection getChildren(){
    return mChildren;
  }

  public String getName() {
    return mName;
  }

  public Object getValue() {
    return mValue;
  }

  public boolean isAttribute() {
    return mIsAttribute;
  }

  public boolean isLeaf() {
    return mChildren.size() == 0;
  }

  /**
   * Return all the keys in this XMLProperties as a Set
   */
  //  public Set keySet() {
  //    return mChildren.keySet();
  //  }

  public void setAttribute (boolean isAttribute) {
    mIsAttribute = isAttribute;
  }

  public void setChild (XMLPropertyNode child) {
    mChildren.addElement(child);
  }

  public void setName(String name) {
    mName = name;
  }

  public void setValue(Object value) {
    mValue = value;
  }

  public String toString() {
    StringBuffer buffer = new StringBuffer();
    if (mIsAttribute){
      buffer.append("[");
      buffer.append(mName);
      buffer.append(" = ");
      buffer.append(mValue);
      buffer.append("]");
    }else{
      buffer.append("<");
      buffer.append(mName);
      buffer.append(" = ");
      buffer.append(mValue);
      buffer.append(">");
    }
    return buffer.toString();
  }


}
