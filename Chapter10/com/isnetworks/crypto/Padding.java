package com.isnetworks.crypto;

import javax.crypto.*;

/**
 *	Interface to cover Padding requirements
 */
public interface Padding {

	/**
	 *	Encodes the data.
	 */
	public byte[] encode(byte[] message, int length) throws IllegalBlockSizeException;

	/**
	 *	Decodes the data.
	 */
	public byte[] decode(byte[] message) throws BadPaddingException;
}