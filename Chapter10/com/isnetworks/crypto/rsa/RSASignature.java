package com.isnetworks.crypto.rsa;

import com.isnetworks.crypto.Padding;

import java.math.BigInteger;
import java.security.spec.*;
import java.security.interfaces.*;
import java.security.*;

/**
 *	Implementation of RSA Signatures for the JCA.
 */
public abstract class RSASignature extends SignatureSpi {

	private final static int SIGN_MODE = 1;
	private final static int VERIFY_MODE = 2;

	/**
	 *	Internal message digest
	 */
	private MessageDigest mHasher;

	/**
	 *	Padding mode -- currently only PKCS#1 is supported.
	 */
	private Padding mPadding;

	/**
	 *	operating mode: sign or verify.
	 */
	private int mOperatingMode;

	/**
	 *	The key to use for operations.
	 *	private key for signing, public for verifying.
	 */
	private Key mKey;

	private boolean mInitialized = false;

	public RSASignature() {
		super();
	}

	protected void setMessageDigest(MessageDigest hasher) {
		mHasher = hasher;
	}

	protected void setPadding(Padding padding) {
		mPadding = padding;
	}

	protected void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
		if (!(privateKey instanceof RSAPrivateKey)) {
			throw new InvalidKeyException("Key must be an RSAPrivateKey");
		}
		mOperatingMode = SIGN_MODE;
		mHasher.reset();
		mKey = privateKey;
		mInitialized = true;
	}

	protected void engineInitSign(PrivateKey privateKey, SecureRandom random)
		throws InvalidKeyException {
		// We use no random in PKCS1 signing.
		this.engineInitSign(privateKey);
	}

	protected void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
		if (!(publicKey instanceof RSAPublicKey)) {
			throw new InvalidKeyException("Key must be an RSAPublicKey");
		}
		mOperatingMode = VERIFY_MODE;
		mHasher.reset();
		mKey = publicKey;
		mInitialized = true;
	}

	protected void engineSetParameter(AlgorithmParameterSpec params)
		throws InvalidAlgorithmParameterException {

		throw new InvalidAlgorithmParameterException("RSASignature does not accept algorithm parameters");
	}

	protected void engineSetParameter(String param, Object value) throws InvalidParameterException {
		throw new InvalidParameterException("RSASignature does not accept algorithm parameters");
	}

	protected Object engineGetParameter(String param) {
		return null;
	}

	protected void engineUpdate(byte[] b, int off, int len) throws SignatureException {
		if (!mInitialized) {
			throw new SignatureException("Signature not initialized");
		}
		// We don't need to keep the message, just the message digest.
		mHasher.update(b, off, len);
	}

	protected void engineUpdate(byte b) throws SignatureException {
		byte[] byteArray = new byte[1];
		byteArray[0] = b;
		engineUpdate(byteArray,0,1);
	}

	/**
	 *	Signs the data and resets the signature object.
	 */
	protected byte[] engineSign() throws SignatureException {
		if (!mInitialized) {
			throw new SignatureException("Signature not initialized");
		}
		if (mOperatingMode != SIGN_MODE) {
			throw new SignatureException("Signature not in signing mode");
		}

		int k = (((RSAPrivateKey)mKey).getModulus().bitLength()+7)/8;
		byte[] hash = mHasher.digest();
		byte[] S = null;
		try {
			byte[] EM = mPadding.encode(hash, k-1);
			BigInteger m = new BigInteger(1, EM);
			BigInteger s = RSA.rsasp1((RSAPrivateKey)mKey, m);
			S = Util.I2OSP(s, k);
		} catch (javax.crypto.IllegalBlockSizeException ibse) {
			throw new SignatureException(ibse.getMessage());
		}
		return S;
	}

	protected int engineSign(byte[] outbuf, int offset, int len)
		throws SignatureException {

		byte[] output = engineSign();
		if (output.length > len) {
			throw new SignatureException("buffer too small");
		}
		System.arraycopy(output,0,outbuf,offset,output.length);
		return output.length;
	}

	/**
	 *	Verifies the signature and resets the signature object.
	 */
	protected boolean engineVerify(byte[] sigBytes) throws SignatureException {

		if (!mInitialized) {
			throw new SignatureException("Signature not initialized");
		}
		if (!(mOperatingMode == VERIFY_MODE)) {
			throw new SignatureException("Signature not in verify mode");
		}

		int k = (((RSAPublicKey)mKey).getModulus().bitLength()+7)/8;
		BigInteger s = new BigInteger(1, sigBytes);
		byte[] EM = null;
		byte[] EMPrime = null;
		try {
			BigInteger m = RSA.rsavp1((RSAPublicKey)mKey, s);
			EM = Util.I2OSP(m, k-1);
			byte[] hash = mHasher.digest();
			EMPrime = mPadding.encode(hash, k-1);
		} catch (javax.crypto.IllegalBlockSizeException ibse) {
			throw new SignatureException(ibse.getMessage());
		}

		// Compare EM and EMPrime
		if (EM.length != EMPrime.length) {
			return false;
		}
		for (int i = 0; i < EM.length; i++) {
			if (EM[i] != EMPrime[i]) {
				return false;
			}
		}
		// All tests passed.
		return true;
	}

}
