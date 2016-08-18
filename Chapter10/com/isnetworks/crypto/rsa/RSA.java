package com.isnetworks.crypto.rsa;

import java.math.*;
import java.security.*;
import java.security.interfaces.*;

import javax.crypto.*;

public class RSA {

	/**
	 *	Encrypt a BigInteger with an RSA public key.
	 */
	public static BigInteger rsaep (RSAPublicKey publicKey, BigInteger m)
		throws IllegalBlockSizeException {

		BigInteger e = publicKey.getPublicExponent();
		BigInteger n = publicKey.getModulus();

		// Check if m is in range
		BigInteger nMinusOne = n.subtract(BigInteger.ONE);

		// m > 0 and m < n-1
		if (m.compareTo(BigInteger.ZERO) < 0) {
			throw new IllegalBlockSizeException("Ciphertext too small");
		}
		if (m.compareTo(nMinusOne) > 0) {
			throw new IllegalBlockSizeException("Ciphertext too large");
		}

		// Here it is: RSA encryption in all its glory:
		BigInteger c = m.modPow(e,n);

		return c;
	}

	/**
	 *	Decrypt a BigInteger with an RSA private key.
	 */
	public static BigInteger rsadp (RSAPrivateKey privateKey, BigInteger c) {

		if (!(privateKey instanceof RSAPrivateCrtKey)) {
			// Can't use the Chinese Remainer Theorum
			BigInteger d = privateKey.getPrivateExponent();
			BigInteger n = privateKey.getModulus();

			// RSA decrypt
			BigInteger m = c.modPow(d,n);

			return m;
		}
		// Use Chinese Remainder Theorum to speed up calculation
		RSAPrivateCrtKey privateCrtKey = (RSAPrivateCrtKey)privateKey;

		BigInteger p = privateCrtKey.getPrimeP();
		BigInteger q = privateCrtKey.getPrimeQ();
		BigInteger dP = privateCrtKey.getPrimeExponentP();
		BigInteger dQ = privateCrtKey.getPrimeExponentQ();
		BigInteger qInv = privateCrtKey.getCrtCoefficient();

		BigInteger m1 = c.modPow(dP,p);
		BigInteger m2 = c.modPow(dQ,q);

		// Let h = qInv(m1 - m2) mod p
		BigInteger h = m1.subtract(m2);
		h = h.multiply(qInv);
		h = h.mod(p);

		// m = m2 + hq
		BigInteger m = h.multiply(q);
		m = m.add(m2);

		return m;
	}

	/**
	 *	Sign a message
	 */
	public static BigInteger rsasp1 (RSAPrivateKey privateKey, BigInteger m)
		throws IllegalBlockSizeException {

		BigInteger n = privateKey.getModulus();

		// Check if m is in range
		BigInteger nMinusOne = n.subtract(BigInteger.ONE);

		// m > 0 and m < n-1
		if (m.compareTo(BigInteger.ZERO) < 0) {
			throw new IllegalBlockSizeException("message too small");
		}
		if (m.compareTo(nMinusOne) > 0) {
			throw new IllegalBlockSizeException("message too large");
		}

		if (!(privateKey instanceof RSAPrivateCrtKey)) {
			BigInteger d = privateKey.getPrivateExponent();
			BigInteger s = m.modPow(d,n);
			return s;
		}

		// Use the Chinese Remainder Theorum for efficiency
		RSAPrivateCrtKey K = (RSAPrivateCrtKey)privateKey;
		BigInteger p = K.getPrimeP();
		BigInteger q = K.getPrimeQ();
		BigInteger dP = K.getPrimeExponentP();
		BigInteger dQ = K.getPrimeExponentQ();
		BigInteger qInv = K.getCrtCoefficient();

		BigInteger s1 = m.modPow(dP, p);
		BigInteger s2 = m.modPow(dQ, q);

		// h = qInv(s1 - s2) mod p
		BigInteger h = s1.subtract(s2);
		h = h.multiply(qInv);
		h = h.mod(p);

		// s = s2 + hq
		BigInteger s = h.multiply(q);
		s = s.add(s2);

		return s;
	}

	/**
	 *	Verify a message
	 */
	public static BigInteger rsavp1(RSAPublicKey publicKey, BigInteger s)
		throws IllegalBlockSizeException {
		BigInteger n = publicKey.getModulus();

		// Check if m is in range
		BigInteger nMinusOne = n.subtract(BigInteger.ONE);

		// s > 0 and s < n-1
		if (s.compareTo(BigInteger.ZERO) < 0) {
			throw new IllegalBlockSizeException("message too small");
		}
		if (s.compareTo(nMinusOne) > 0) {
			throw new IllegalBlockSizeException("message too large");
		}
		BigInteger e = publicKey.getPublicExponent();

		BigInteger m = s.modPow(e,n);

		return m;
	}

}