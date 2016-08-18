package com.isnetworks.crypto.rsa;

import com.isnetworks.crypto.Padding;

import java.io.*;
import java.math.BigInteger;
import java.security.*;
import java.security.interfaces.*;

import javax.crypto.*;

/**
 *	JCE-based implementation of the RSA cipher.
 *
 *	See RSA's PKCS#1 documentation for details on
 *	how RSA encrypts and decrypts.
 *
 */
public final class RSACipher extends CipherSpi {

	/**
	 *	We support two types of padding: PKCS1 and OAEP
	 */
    private static final int PKCS1 = 1;
    private static final int OAEP = 2;

    private int mPaddingType;
    private Key mKey;

    /**
     *	This handles all our padding operations.
     */
    private Padding mPadding;

    /**
     *	Two possible modes: Encrypt and Decrypt:
     *	Cipher.ENCRYPT_MODE and Cipher.DECRYPT_MODE
     */
    private int mOperatingMode;

    /**
     *	Holds our data to be encrypted or decrypted.
     */
    private ByteArrayOutputStream mBaos;

    /**
     *  This is the size of the modulus
     */
    private int mKeysize;

    /**
     *	OAEP Padding support algorithm parameters,
     *	so we keep track of them.
     */
    private AlgorithmParameters mAlgorithmParameters;

    /** Creates new RSACipher */
    public RSACipher() {
        super();
        mBaos = new ByteArrayOutputStream();
    }

	/**
	 *	Sets the mode for the cipher. We support only ECB mode,
	 *	"Electronic CodeBook".
	 */
    protected void engineSetMode(String mode) throws NoSuchAlgorithmException {
        if (!mode.equalsIgnoreCase("ECB")) {
            throw new NoSuchAlgorithmException("RSA supports only ECB mode");
        }
    }

	/**
	 *	Sets the padding for this cipher.
	 *	We support two paddings: PKCS1 and OAEP.
	 */
    protected void engineSetPadding(String padding) throws NoSuchPaddingException {
        if(padding.equalsIgnoreCase("PKCS1") ||
        padding.equalsIgnoreCase("PKCS#1") ||
        padding.equalsIgnoreCase("PKCS1Padding")) {
            mPaddingType = PKCS1;
        } else if (padding.equalsIgnoreCase("OAEP") || padding.equalsIgnoreCase("OAEPPadding")) {
            mPaddingType = OAEP;
        } else {
            throw new NoSuchPaddingException("Only PKCS1 and OAEP Padding supported");
        }
    }

	/**
	 *	Returns the block size of this cipher.
	 *	It will vary depending on whether it is in
	 *	encrypt mode or decrypt mode.
	 */
    protected int engineGetBlockSize() {
        if (mOperatingMode == Cipher.ENCRYPT_MODE) {
            return mKeysize - 1;
        } else {
            return mKeysize;
        }
    }

	/**
	 *	Returns the output size of this cipher.
	 *	It will vary depending on whether it is in
	 *	encrypt mode or decrypt mode.
	 */
    protected int engineGetOutputSize(int inputLen) {
        if (mOperatingMode == Cipher.ENCRYPT_MODE) {
            return mKeysize;
        } else {
            return mKeysize -1;
        }
    }

	/**
	 *	IVs are not supported in ECB mode, so this will always return null.
	 */
    protected byte[] engineGetIV() {
        return null;
    }

	/**
	 *	Returns the algorithm parameters used to initialize this
	 *	cipher. May be null.
	 */
    protected AlgorithmParameters engineGetParameters() {
        return mAlgorithmParameters;
    }

	/**
	 *	Initialize the cipher. Resets all values.
	 */
    protected void engineInit(int opmode, Key key, AlgorithmParameters params, SecureRandom random)
    throws InvalidKeyException, InvalidAlgorithmParameterException  {
        int modulusLength = 0;
        if (key instanceof RSAPublicKey) {
			if (!(opmode == Cipher.ENCRYPT_MODE)) {
				throw new InvalidKeyException("Public Keys can only be used for encrypting");
			}
            modulusLength = ((RSAPublicKey)key).getModulus().bitLength();
        } else if (key instanceof RSAPrivateKey) {
			if (!(opmode == Cipher.DECRYPT_MODE)) {
				throw new InvalidKeyException("Private Keys can only be used for decrypting");
			}
            modulusLength = ((RSAPrivateKey)key).getModulus().bitLength();
        } else {
            throw new InvalidKeyException("Key must be an RSA Key");
        }
        // The keysize is the size of the modulus in bytes.
        // We add 7 to round up to the nearest byte.
        mKeysize = (modulusLength+7)/8;

		// If we're using OAEP padding, we may need to pass parameters
		// to the padding object.
        if (mPaddingType == OAEP) {
            if (params == null) {
                mPadding = new OAEPPadding(random);
            } else {
                mPadding = new OAEPPadding(params, random);
            }
        } else {
            mPadding = new PKCS1Padding(random);
        }
        mAlgorithmParameters = params;
        mKey = key;
        mOperatingMode = opmode;
        mBaos.reset();
    }

	/**
	 *	Initializes the cipher by calling a different internal engineInit method.
	 *
	 *	This method does not have an AlgorithmParameter object.
	 */
    protected void engineInit(int opmode, Key key, SecureRandom random) throws InvalidKeyException {
		try {
        	engineInit(opmode, key, (AlgorithmParameters)null, random);
		} catch (InvalidAlgorithmParameterException iape) {
			// This should never happen, as the alg params are null
			iape.printStackTrace();
		}
    }

	/**
	 *	Not supported -- we have no AlgorithmParameterSpec defined.
	 */
    protected void engineInit(int opmode, Key key, java.security.spec.AlgorithmParameterSpec params, SecureRandom random)
    throws InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("This cipher does not accept AlgorithmParameterSpec");
    }

	/**
	 *	Updates the cipher using the data given as input.
	 */
    protected byte[] engineUpdate(byte[] input, int inputOffset, int inputLen) {
		if (input != null) {
			mBaos.write(input, inputOffset, inputLen);
		}
        return null;
    }

    /**
     *	We do not support encrypting into a buffer during updates,
     *	so we just return 0.
     */
    protected int engineUpdate(byte[] input, int inputOffset, int inputLen, byte[] output, int outputOffset) {
        engineUpdate(input, inputOffset, inputLen);
        return 0;
    }

	/**
	 *	Actually encrypts the data given.
	 */
    protected byte[] engineDoFinal(byte[] input, int inputOffset, int inputLen)
    	throws IllegalBlockSizeException, BadPaddingException {

		engineUpdate(input, inputOffset, inputLen);

		byte[] output;
		// Call one of our internal methods for encrypting or
		// decrypting our data.
		if (mOperatingMode == Cipher.ENCRYPT_MODE) {
			output = encrypt();
		} else {
			output = decrypt();
		}
		// reset our data buffer
		mBaos.reset();
		return output;
	}

	/**
	 *	Convenience method for encrypting that places the output in a
	 *	buffer provided by the caller.
	 */
	protected int engineDoFinal(byte[] input, int inputOffset, int inputLen, byte[] output, int outputOffset)
		throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {

		byte[] buffer;
		buffer = engineDoFinal(input, inputOffset, inputLen);
		if (output.length - outputOffset < buffer.length) {
			throw new ShortBufferException("Output longer than buffer");
		}
		System.arraycopy(buffer, 0, output, outputOffset, buffer.length);
		return buffer.length;
	}

	/**
	 *	Internal method for encrypting using padding.
	 */
    private byte[] encrypt() throws IllegalBlockSizeException {
		byte[] M = mBaos.toByteArray();
        int k = mKeysize;
        byte[] EM = mPadding.encode(M,k-1);
        BigInteger m = new BigInteger(1, EM);
        BigInteger c = RSA.rsaep((RSAPublicKey)mKey, m);
        byte[] C = Util.I2OSP(c, k);
        return C;
    }

	/**
	 *	Internal method for decrypting an padded message.
	 */
    private byte[] decrypt() throws BadPaddingException, IllegalBlockSizeException {
		byte[] C = mBaos.toByteArray();
        int k = mKeysize;
        if (k != C.length) {
			throw new IllegalBlockSizeException("decryption error");
		}
		BigInteger c = new BigInteger(1,C);
		BigInteger m = RSA.rsadp((RSAPrivateKey)mKey,c);
		byte[] EM = Util.I2OSP(m,k-1);
		byte[] M = mPadding.decode(EM);
		return M;
	}
}