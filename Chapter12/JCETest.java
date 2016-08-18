import java.security.*;
import javax.crypto.*;
import sun.misc.BASE64Encoder;

/**
 *	Test class for our JCE provider of the RSA algorithm.
 *
 *	Generates a key pair, then encrypts and decrypts a message.
 */
public class JCETest {

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

		// Encrypt the message with the public key.
		Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPPadding","ISNetworks");
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] encryptedMessage = cipher.doFinal(messageBytes);

		System.out.println("Encrypted message:\n" + encoder.encode(encryptedMessage));

		// Decrypt the encrypted data with the private key.
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] decryptedMessage = cipher.doFinal(encryptedMessage);
		String decryptedMessageString = new String(decryptedMessage,"UTF8");

		System.out.println("\nDecrypted message: " + decryptedMessageString);

		// Check that the decrypted message and the original
		// message are the same.
		if (decryptedMessageString.equals(message)) {
			System.out.println("\nTest succeeded.");
		} else {
			System.out.println("\nTest failed.");
		}
	}
}
