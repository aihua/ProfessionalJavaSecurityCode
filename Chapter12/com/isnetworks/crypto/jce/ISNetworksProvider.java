package com.isnetworks.crypto.jce;

import java.security.*;

/**
 *	ISNetworks cryptography provider
 *
 *	This provider supports RSA encryption, decryption,
 *	signatures, and key generation.
 */
public final class ISNetworksProvider extends java.security.Provider {

	private static final String NAME = "ISNetworks";

	private static final double VERSION = 1.0;

	private static final String INFO = "ISNetworks RSA Provider";

	public ISNetworksProvider() {
		super (NAME, VERSION, INFO);

		// Need to call doPrivileged, in case our caller
		// does not have permission to register a security
		// provider, but we do.
		AccessController.doPrivileged(new java.security.PrivilegedAction() {
			public Object run() {

				put("Cipher.RSA","com.isnetworks.crypto.rsa.RSACipher");

				put("KeyPairGenerator.RSA","com.isnetworks.crypto.rsa.RSAKeyPairGenerator");

				put("Signature.MD5withRSA", "com.isnetworks.crypto.rsa.MD5WithRSASignature");
				put("Signature.SHA1withRSA", "com.isnetworks.crypto.rsa.SHA1WithRSASignature");

				return null;
			}
		});

	}

}