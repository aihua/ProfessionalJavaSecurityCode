package com.isnetworks.crypto.rsa;

import java.math.BigInteger;
import java.security.*;
import java.security.interfaces.*;

public class RSAPrivateCrtKeyImpl extends RSAPrivateKeyImpl {

	private BigInteger mPublicExponent;	// e
	private BigInteger mPrimeP;			// p
	private BigInteger mPrimeQ;			// q
	private BigInteger mPrimeExponentP;	// d mod (p-1), dP
	private BigInteger mPrimeExponentQ;	// d mod (q-1), dQ
	private BigInteger mCrtCoefficient;	// (q^-1) mod p, qInv

	/**
	 *	Constructor
	 *
	 *	Given n, d, e, p, and q, compute dP, dQ, and qInv.
	 */
	protected RSAPrivateCrtKeyImpl (
		BigInteger modulus,
		BigInteger privateExponent,
		BigInteger publicExponent,
		BigInteger primeP,
		BigInteger primeQ) {

		super(modulus,privateExponent);

		mPublicExponent = publicExponent;
		mPrimeP = primeP;
		mPrimeQ = primeQ;

		mPrimeExponentP = super.getPrivateExponent().mod(mPrimeP.subtract(BigInteger.ONE));
		mPrimeExponentQ = super.getPrivateExponent().mod(mPrimeQ.subtract(BigInteger.ONE));
		mCrtCoefficient = mPrimeQ.modInverse(mPrimeP);
	}

	public BigInteger getPublicExponent() {
		return mPublicExponent;
	}

	public BigInteger getPrimeP() {
		return mPrimeP;
	}

	public BigInteger getPrimeQ() {
		return mPrimeQ;
	}

	public BigInteger getPrimeExponentP() {
		return mPrimeExponentP;
	}

	public BigInteger getPrimeExponentQ() {
		return mPrimeExponentQ;
	}

	public BigInteger getCrtCoefficient() {
		return mCrtCoefficient;
	}
}