package com.isnetworks.crypto.rsa;

import com.isnetworks.crypto.*;

import java.io.*;
import java.security.*;

import javax.crypto.*;

/**
 *	Padding implementation for PKCS #1 signatures.
 */
public class PKCS1SignaturePadding implements Padding{

	/**
	 *	The length of the hash which our
	 *	internal message digest function will
	 *	produce.
	 */
	private int mHLen;

	/**
	 *	T's default value for the chosen hash function.
	 */
	private byte[] mTDefault;

	public static final int SHA1 = 1;
	public static final int MD5 = 2;

	/**
	 *	ASN.1 digest info streams
	 *
	 *	These are used in creating the encoding.
	 *	We support only SHA-1 and MD5.
	 */
	private final static byte[] SHA1_DIGEST_INFO = {
		(byte)0x30, (byte)0x21, (byte)0x30, (byte)0x09, (byte)0x06,
		(byte)0x05, (byte)0x2b, (byte)0x0e, (byte)0x03, (byte)0x02,
		(byte)0x1a, (byte)0x05, (byte)0x00, (byte)0x04, (byte)0x14,
		(byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00,
		(byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00,
		(byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00,
		(byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00
	};

	private final static byte[] MD5_DIGEST_INFO = {
		(byte)0x30, (byte)0x20, (byte)0x30, (byte)0x0c, (byte)0x06,
		(byte)0x08, (byte)0x2a, (byte)0x86, (byte)0x48, (byte)0x86,
		(byte)0xf7, (byte)0x0d, (byte)0x02, (byte)0x05, (byte)0x05,
		(byte)0x00, (byte)0x04, (byte)0x10, (byte)0x00, (byte)0x00,
		(byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00,
		(byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00,
		(byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00
	};

	/**
	 *	Constructor
	 *
	 *	A hash algorithm must be chosen, either MD5 or SHA-1.
	 */
	public PKCS1SignaturePadding(int hashAlgorithm) {
		String algorithmName = null;

		// Fill mTDefault with the appropriate byte array
		if (hashAlgorithm == MD5) {
			algorithmName = "MD5";
			mTDefault = new byte[MD5_DIGEST_INFO.length];
			System.arraycopy(MD5_DIGEST_INFO,0,mTDefault,0,mTDefault.length);
			mHLen = 16;
		} else {
			algorithmName = "SHA";
			mTDefault = new byte[SHA1_DIGEST_INFO.length];
			System.arraycopy(SHA1_DIGEST_INFO,0,mTDefault,0,mTDefault.length);
			mHLen = 20;
		}
	}

	/**
	 *	Default constructor -- use SHA-1.
	 */
	public PKCS1SignaturePadding() {
		this(SHA1);
	}

	/**
	 *	Encode a PKCS1 Signature block
	 *
	 *	@param	The hash to be encoded
	 *	@param	The length of the resulting block
	 */
	public byte[] encode(byte[] H, int emLen)
		throws IllegalBlockSizeException {

		if (emLen < mTDefault.length + 10) {
			throw new IllegalBlockSizeException("encoding too short");
		}

		byte[] T = new byte[mTDefault.length];
		System.arraycopy(mTDefault,0,T,0,T.length);

		System.arraycopy(H,0,T,T.length - mHLen,mHLen);

		// Create PS, filled with 0xFF
		byte[] PS = new byte[emLen - T.length - 2];
		for (int i = 0; i < PS.length; i++) {
			PS[i] = (byte)0xFF;
		}

		// Create the output block, 01 || PS || 00 || T.
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			baos.write((byte)0x01);
			baos.write(PS);
			baos.write((byte)0x00);
			baos.write(T);
		} catch (IOException ioe) {
			// This should never happen
			ioe.printStackTrace();
		}

		byte[] EM = baos.toByteArray();
		return EM;
	}

	/**
	 *	PKCS1 signature padding does not define a decode
	 *	method, but our Padding interface requires it.
	 *	Throw a runtime exception if it is called.
	 */
	public byte[] decode(byte[] H) {
		throw new RuntimeException("Decode not used in PKCS1 Signature Padding");
	}
}