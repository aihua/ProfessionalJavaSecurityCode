package com.isnetworks.crypto.rsa;

import com.isnetworks.crypto.Padding;

import java.security.*;

/**
 *	Implementation of RSASignature using the MD5
 *	hashing algorithm.
 */
public class MD5WithRSASignature extends RSASignature {

	public MD5WithRSASignature() {
		super();

		// Now we need to set the padding and the message digest.
		Padding padding = new PKCS1SignaturePadding(PKCS1SignaturePadding.MD5);
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException nsae) {
			// This should never happen as Sun provides MD5
			nsae.printStackTrace();
		}
		super.setMessageDigest(messageDigest);
		super.setPadding(padding);
	}
}
