package com.isnetworks.crypto.rsa;

import java.math.BigInteger;
import java.security.*;
import java.security.interfaces.*;

public class RSAPublicKeyImpl implements RSAPublicKey {

	// The modulus, n
	private BigInteger mModulus;

	// The public exponent, e
	private BigInteger mPublicExponent;

	protected RSAPublicKeyImpl (BigInteger modulus, BigInteger publicExponent) {
		mModulus = modulus;
		mPublicExponent = publicExponent;
	}

	public BigInteger getModulus() {
		return mModulus;
	}

	public BigInteger getPublicExponent() {
		return mPublicExponent;
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