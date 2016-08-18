import java.security.*;

import sun.misc.BASE64Encoder;

/**
 *	Test class for our JCE provider of RSA signatures.
 *
 *	Generates a key pair, then signs a message and verifies
 *	the signature.
 */
public class SignatureTest {

	public static void main(String[] args) throws Exception {

		String message = "This is a test";
		if (args.length != 0) {	// Args provided
			message = args[0];
		}

		// Create a base-64 encoder for displaying binary data.
		BASE64Encoder encoder = new BASE64Encoder();

		// Register the provider.
		Security.addProvider(new com.isnetworks.crypto.jce.ISNetworksProvider());

		// First generate an RSA key pair.
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA","ISNetworks");
		kpg.initialize(1024);
		System.out.println("Generating a key pair...");
		KeyPair keyPair = kpg.generateKeyPair();
		System.out.println("Done generating keys.\n");

		// Get the public and private keys.
		PublicKey publicKey =  keyPair.getPublic();
		PrivateKey privateKey = keyPair.getPrivate();

		// Create a byte array from the message.
		byte[] messageBytes = message.getBytes("UTF8");

		// Get a Signature instance.
		Signature signer = Signature.getInstance("SHA1withRSA","ISNetworks");

		// Sign the message.
		signer.initSign(privateKey);
		signer.update(messageBytes);
		byte[] signatureBytes = signer.sign();

		System.out.println("\nThe signature: \n"+encoder.encode(signatureBytes)+"\n");

		// To verify, we need to re-initialize the Signature instance,
		// with the public key instead of the private.
		signer.initVerify(publicKey);
		signer.update(messageBytes);
		boolean valid = signer.verify(signatureBytes);

		if (valid) {
			System.out.println("Signature is valid.");
		} else {
			System.out.println("Signature is invalid.");
		}
	}
}
