package com.isnetworks.crypto.rsa;

import java.io.*;
import java.security.*;

import javax.crypto.*;

import com.isnetworks.crypto.Padding;

/**
 *	Optimal Asymmetric Encryption Padding
 */
public class OAEPPadding implements Padding {

	/**
	 *	Internal MessageDigest, will be SHA-1.
	 */
	private MessageDigest mHasher;

	/**
	 *	Length of the hash function.
	 */
	private int mHLen;

	/**
	 *	Instance of SecureRandom to use for
	 *	random seed.
	 */
	private SecureRandom mRandom;

	/**
	 *	Mask Generator Function.
	 */
	private MGF mMask;

	/**
	 *	The encoded parameters, if present.
	 */
	private byte[] mPBytes;

	/**
	 *	Constructor
	 *
	 *	@param	instance of SecureRandom to use
	 */
	public OAEPPadding (SecureRandom random) {
		try {
			mHasher = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException nsae) {
			// Should never happen, as Sun ships
			// a SHA-1 implementation with the JDK.
			nsae.printStackTrace();
			throw new RuntimeException("No SHA-1 implementation found");
		}
		mHLen = mHasher.getDigestLength();
		mRandom = random;
		mMask = new MGF();
	}

	/**
	 *	Default constructor
	 */
	public OAEPPadding() {
		this(new SecureRandom());
	}

	/**
	 *	Constructor using an AlgorithmParameters object
	 *	and an instance of SecureRandom.
	 */
	public OAEPPadding(AlgorithmParameters P, SecureRandom random)
		throws InvalidAlgorithmParameterException {

		this(random);
		if (P != null) {
			try {
				mPBytes = P.getEncoded();
			} catch (IOException ioe) {
				throw new InvalidAlgorithmParameterException("Bad AlgorithmParameters");
			}
		}
	}

	/**
	 *	Constructor using an AlgorithmParameters object.
	 *	Creates its own instance of SecureRandom.
	 */
	public OAEPPadding(AlgorithmParameters P)
		throws InvalidAlgorithmParameterException {

		this(P, new SecureRandom());
	}


	/**
	 *	Return an encoded byte array
	 *
	 *	@param	length of encoded message desired
	 */
	public byte[] encode(byte[] M, int length)
		throws IllegalBlockSizeException {

		if (mPBytes == null) {
			mPBytes = new byte[0];
		}

		// Check that the message is small enough
		if (M.length > (length - 2*mHLen -1)) {
			throw new IllegalBlockSizeException ("message too long");
		}

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] PS = new byte[(length - M.length - 2*mHLen -1)];
		byte[] EM;
		mHasher.reset();
		byte[] pHash = mHasher.digest(mPBytes);

		// Create DB, the Data Block
		try {
			baos.write(pHash);
			baos.write(PS);
			baos.write(0x01);
			baos.write(M);
		} catch (IOException ioe) {
			// This will never happen
			ioe.printStackTrace();
		}
		byte[] DB = baos.toByteArray();

		// Generate the seed
		byte[] seed = new byte[mHLen];
		mRandom.nextBytes(seed);
		byte[] dbMask = mMask.generateMask(seed, length - mHLen);

		// Xor DB and dbMask
		byte[] maskedDB = xor(DB, dbMask);

		byte[] seedMask = mMask.generateMask(maskedDB, mHLen);
		byte[] maskedSeed = xor(seed, seedMask);

		baos.reset();
		try {
			baos.write(maskedSeed);
			baos.write(maskedDB);
		} catch (IOException ioe) {
			// This will never happen
			ioe.printStackTrace();
		}
		EM = baos.toByteArray();
		return EM;
	}

	/**
	 *	Decode an OAEP message
	 *
	 *	@param	the Encoded Message
	 */
	public byte[] decode(byte[] EM)
		throws BadPaddingException {

		if (EM.length < (2*mHLen + 1)) {
			throw new BadPaddingException("decoding error");
		}

		if (mPBytes == null) {
			mPBytes = new byte[0];
		}
		byte[] M;

		// Create maskedSeed, first hLen octets of EM
		byte[] maskedSeed = new byte[mHLen];
		System.arraycopy(EM,0,maskedSeed,0,mHLen);

		// Create maskedDB, remaining octets
		byte[] maskedDB = new byte[EM.length - mHLen];
		System.arraycopy(EM,mHLen,maskedDB,0,EM.length - mHLen);

		// seedMask = MGF(maskedDB, hLen)
		byte[] seedMask = mMask.generateMask(maskedDB,mHLen);

		// seed = maskedSeed \xor seedMask
		byte[] seed = xor(maskedSeed, seedMask);

		// dbMask = MGF(seed, ||EM|| - hLen)
		byte[] dbMask = mMask.generateMask(seed, EM.length - mHLen);

		// DB = maskedDB \xor dbMask
		byte[] DB = xor(maskedDB, dbMask);

		// pHash = Hash(P)
		mHasher.reset();
		byte[] pHash = mHasher.digest(mPBytes);

		// Separate array DB = pHash'||PS||01||M
		byte[] pHashPrime = new byte[mHLen];
		System.arraycopy(DB,0,pHashPrime,0,mHLen);

		if (!areHashesEqual(pHash,pHashPrime)) {
			throw new BadPaddingException("hashing error");
		}

		int pos = mHLen;
		while ( (DB[pos] != (byte)(0x01)) && (DB[pos] == (byte)(0x00)) ) {
			pos++;
			if (pos >= DB.length) {
				// no 0x01 found, and we're at the end
				throw new BadPaddingException("no message found");
			}
		}
		pos++;

		M = new byte[DB.length - pos];
		System.arraycopy(DB,pos,M,0,DB.length - pos);
		return M;
	}

	/**
	 *	Returns a new array, the xor of the two arguments
	 */
	private byte[] xor (byte[] firstArray, byte[] secondArray) {
		int length = (int) Math.max(firstArray.length, secondArray.length);
		byte[] result = new byte[length];
		for (int i=0; i<length; i++) {
			result[i] = (byte)(firstArray[i] ^ secondArray[i]);
		}
		return result;
	}

	/**
	 *	Compare two hashes
	 */
	private boolean areHashesEqual(byte[] hash1, byte[] hash2) {
		// hashes are equal in length, so just compare contents
		for (int i = 0; i < hash1.length; i++) {
			if (hash1[i] != hash2[i]) {
				return false;
			}
		}
		return true;
	}
}