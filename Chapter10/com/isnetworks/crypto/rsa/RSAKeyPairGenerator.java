package com.isnetworks.crypto.rsa;

import java.security.*;
import java.math.BigInteger;

/**
 *	Generates RSA keys of arbitrary size.
 */
public final class RSAKeyPairGenerator extends KeyPairGeneratorSpi {

	/**
	 *	We will use a standard value for E for all our keys.
	 */
	private static final BigInteger E = BigInteger.valueOf(65537);

	/**
	 *	The certainty defines how likely a number
	 *	we generate is to be prime. The probability of
	 *	the numbers being prime is 1 - 1/2^certainty.
	 */
	private static final int CERTAINTY = 85;

	/**
	 *	If no strength is specified, return keys with
	 *	a modulus 1024 bits in length.
	 */
	private static final int DEFAULT_STRENGTH = 1024;

	private int mKeysize;
	private SecureRandom mSecureRandom;
	private BigInteger mPublicExponent;
	private boolean mInitialized = false;

	public RSAKeyPairGenerator() {
		super();
	}

	public void initialize(int keysize, SecureRandom random) {
		mKeysize = keysize;
		mSecureRandom = random;
		mInitialized = true;
	}

	public KeyPair generateKeyPair() {
		if (!mInitialized) {
			initialize(DEFAULT_STRENGTH, new SecureRandom());
		}

		// p needs to be have the length of the keysize.
		int pSize = mKeysize/2;

		// q's length is the remaining length of the key.
		int qSize = mKeysize - pSize;
		BigInteger p,q,pMinus1,qMinus1,phi,n,d;

		do {	// Generate p and q until n is the size requested.

			do {	// Generate p until p-1 is relatively prime to E.
				p = new BigInteger(pSize, CERTAINTY, mSecureRandom);
				pMinus1 = p.subtract(BigInteger.ONE);
			} while (!(pMinus1.gcd(E).equals(BigInteger.ONE)));

			do {	// Generate q until q-1 is relatively prime to E.
				q = new BigInteger(qSize, CERTAINTY, mSecureRandom);
				qMinus1 = q.subtract(BigInteger.ONE);
			} while (!(qMinus1.gcd(E).equals(BigInteger.ONE)));

		} while ((p.multiply(q)).bitLength() != mKeysize);

		// phi = (p-1)(q-1)
		phi = pMinus1.multiply(qMinus1);

		// n = pq
		n = p.multiply(q);

		// d = e^-1 mod phi
		d = E.modInverse(phi);

		// Create the key pair and return it.
		return new KeyPair(
			new RSAPublicKeyImpl(n,E),
			new RSAPrivateCrtKeyImpl(n,d,E,p,q)
		);
	}
}






