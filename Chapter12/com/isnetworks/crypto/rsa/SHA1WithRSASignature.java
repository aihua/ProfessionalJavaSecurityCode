package com.isnetworks.crypto.rsa;

import com.isnetworks.crypto.Padding;

import java.security.*;

/**
 *	Implementation of RSASignature using the SHA-1
 *	hashing algorithm.
 */
public class SHA1WithRSASignature extends RSASignature {

	public SHA1WithRSASignature() {
		super();

		// Now we need to set the padding and the message digest.
		Padding padding = new PKCS1SignaturePadding(PKCS1SignaturePadding.SHA1);
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("SHA1");
		} catch (NoSuchAlgorithmException nsae) {
			// This should never happen as Sun provides SHA1
			nsae.printStackTrace();
		}
		super.setMessageDigest(messageDigest);
		super.setPadding(padding);
	}
}
