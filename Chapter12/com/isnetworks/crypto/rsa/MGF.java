package com.isnetworks.crypto.rsa;

import java.security.*;

/**
 *	Mask Generation Function for RSA-OAEP padding.
 *	From RSA Laboratories' PKCS#1, v2.0
 */
public class MGF {

	private MessageDigest mHasher;
	private int mHLen;

	public MGF() {
		try {
			mHasher = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException nsae) {
			// This should never happen, as Sun
			// ships SHA-1 with the JDK.
			nsae.printStackTrace();
			throw new RuntimeException("No SHA-1 implementation found");
		}
		mHLen = mHasher.getDigestLength();
	}

	/**
	 *	Generates a mask based on a seed, and given a length.
	 *
	 *	@param	the seed
	 *	@param	the requested length of the mask
	 *	@returns	the mask
	 */
	public byte[] generateMask(byte[] Z, int length) {
		// Z is the seed.

		// Compute the number of iterations we'll need to
		// fill an array of the appropriate length.
		int iterations = (int)Math.ceil((double)length / (double)mHLen);

		byte[] hash,C;
		byte[] T = new byte[iterations * mHLen];
		mHasher.reset();

		// T = T||Hash(Z||C), where C is an increasing
		// counter 4 bytes in length.
		for (int counter = 0;counter < iterations; counter++) {
			C = intToBytes(counter);
			mHasher.update(Z);
			mHasher.update(C);
			hash = mHasher.digest();
			// Append to T.
			System.arraycopy(hash,0,T,counter * mHLen,mHLen);
		}
		byte[] bytesToReturn = new byte[length];
		System.arraycopy(T,0,bytesToReturn,0,length);
		return bytesToReturn;
	}

	/**
	 *	Internal convenience method for converting
	 *	an int to a byte array of 4 bytes.
	 *
	 *	@param	the int
	 *	@returns	the byte array
	 */
	private static byte[] intToBytes(int i) {
		byte[] bytesToReturn = new byte[4];
		bytesToReturn[0] = (byte)(i >>> 24);
		bytesToReturn[1] = (byte)(i >>> 16);
		bytesToReturn[2] = (byte)(i >>> 8);
		bytesToReturn[3] = (byte)i;
		return bytesToReturn;
	}

}