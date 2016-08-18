package com.isnetworks.crypto.rsa;

import java.math.BigInteger;
import java.security.*;
import java.security.interfaces.*;

public class RSAPrivateKeyImpl implements RSAPrivateKey {

	// The modulus
	private BigInteger mModulus;	// n

	// The private exponent
	private BigInteger mPrivateExponent;	// d

	protected RSAPrivateKeyImpl (BigInteger modulus, BigInteger privateExponent) {
		mModulus = modulus;
		mPrivateExponent = privateExponent;
	}

	public BigInteger getModulus() {
		return mModulus;
	}

	public BigInteger getPrivateExponent() {
		return mPrivateExponent;
	}

	public String getAlgorithm() {
		return "RSA";
	}

	public String getFormat() {
		return "NONE";
	}

	public byte[] getEncoded() {
		return null;
	}
}