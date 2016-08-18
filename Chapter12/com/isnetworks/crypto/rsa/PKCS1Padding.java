package com.isnetworks.crypto.rsa;

import com.isnetworks.crypto.*;

import java.io.*;
import java.security.*;

import javax.crypto.*;

/**
 *	PKCS#1, v1.5
 *
 *	Encodes a message to a specific block size as so:
 *
 *	BT || PS || 00 || M
 *
 *	BT = block type, 0x02 for encryption
 *	PS = Padding String, at least 8 bytes of non-zeroes
 *	M = Message, the original data
 *
 */
public class PKCS1Padding implements Padding{

	private SecureRandom mRandom;

	/**
	 *	Constructor
	 *
	 *	@param	instance of SecureRandom to use
	 */
	public PKCS1Padding (SecureRandom random) {
		mRandom = random;
	}

	/**
	 *	Default constructor
	 */
	public PKCS1Padding() {
		this(new SecureRandom());
	}

	/**
	 *	Encode a message using PKCS#1, v1.5
	 *
	 *	@param	Message to encode
	 *	@param	length of encoded message
	 */
	public byte[] encode(byte[] M, int emLen)
		throws IllegalBlockSizeException {

		if (M.length > emLen - 10) {
			throw new IllegalBlockSizeException("message too long");
		}

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] PS = new byte[(emLen - M.length - 2)];
		// Fill the padding string with random non-zero bytes
		for (int i = 0; i < PS.length; i++) {
			PS[i] = (byte)(mRandom.nextInt(255)+1);
		}
		try {
			baos.write((byte)0x02);
			baos.write(PS);
			baos.write((byte)0x00);
			baos.write(M);
		} catch (IOException ioe) {
			// This should never happen
			ioe.printStackTrace();
		}
		byte[] EM = baos.toByteArray();
		return EM;
	}

	/**
	 *	Decode a PKCS#1, v1.5 message
	 *
	 *	@param	the Encoded Message
	 */
	public byte[] decode(byte[] EM) throws BadPaddingException {

		// Check length
		if (EM.length < 10) {
			throw new BadPaddingException ("message too short");
		}

		// Check that it start with 0x02
		if (EM[0] != (byte) 0x02) {
			throw new BadPaddingException ("message not formatted properly");
		}

		// Need to start by looking for the first non-zero byte
		int start = 0;
		while (EM[start] != (byte)0x00) {
			start++;
			if (start >= EM.length) {
				throw new BadPaddingException("bad padding");
			}
		}
		start++; // Ignore the first 00

		// Check that PS is at least 8 bytes long
		if (start < 10) {
			throw new BadPaddingException ("bad padding");
		}

		byte[] M = new byte[EM.length - start];
		System.arraycopy(EM,start,M,0,M.length);
		return M;
	}
}