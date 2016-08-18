import java.security.*;
import java.io.*;

/**
 *	Simple Time server.
 *
 *	Given a private key, this class will timestamp
 *	an arbitrary input stream.
 */
public class Timestamper {

	private static final String KEYSTORE_FILENAME = "timestamper.ks";

	private MessageDigest mHasher;
	private PrivateKey mPrivateKey;

	public Timestamper(PrivateKey privateKey) {
		mPrivateKey = privateKey;
		try {
			mHasher = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException nsae) {
			// This should never happen, as the JDK comes with SHA-1
			throw new RuntimeException("SHA-1 Unavailable");
		}
	}

	/**
	 *	Reads in an input stream and outputs the timestamp.
	 */
	public byte[] timestamp(InputStream input) throws SignatureException, IOException {
		// Need to store our output in a byte array
		ByteArrayOutputStream output = new ByteArrayOutputStream(156);

		// Begin by hashing the input.
		mHasher.reset();
		int i;
		while ((i = input.read())!= -1) {
			mHasher.update((byte)i);
		}
		byte[] hash1 = mHasher.digest();
		output.write(hash1);

		// Now we need to get the time
		long time = System.currentTimeMillis();
		byte[] timeBytes = longToBytes(time);
		output.write(timeBytes);

		// Produce the second hash from the first hash
		// and the time.
		mHasher.update(hash1);
		mHasher.update(timeBytes);
		byte[] hash2 = mHasher.digest();

		// Now sign the second hash.
		Signature signer = null;
		try {
			signer = Signature.getInstance("SHA1withRSA");
			signer.initSign(mPrivateKey);
		} catch (NoSuchAlgorithmException nsae) {
			// Probably don't have RSA signatures installed
			nsae.printStackTrace();
			System.err.println("Check that an RSA provider is installed.");
			throw new RuntimeException("No suitable provider");
		} catch (InvalidKeyException ike) {
			throw new SignatureException("InvalidKey");
		}
		signer.update(hash2);
		byte[] signatureBytes = signer.sign();

		// Write that to the array.
		output.write(signatureBytes);
		byte[] outputBytes = output.toByteArray();
		return outputBytes;
	}

	/**
	 *	Test method for stamping a file.
	 *
	 *	Arguments are:
	 *		sourcefilename: the file to be timestamped
	 *		password: the password for the keystore
	 *		destinationFilename: the file to store the timestamp in
	 */
	public static void main(String[] args) throws Exception {
		if (args.length != 3) {
			System.err.println("Usage: java Timestamper sourcefilename password destinationFilename");
			System.exit(1);
		}
		String defaultType = KeyStore.getDefaultType();
		KeyStore keystore = KeyStore.getInstance(defaultType);
		char[] password = args[1].toCharArray();
		FileInputStream keystoreStream = new FileInputStream(KEYSTORE_FILENAME);
		keystore.load(keystoreStream, password);
		keystoreStream.close();
		PrivateKey privateKey = (PrivateKey)keystore.getKey("mykey", password);
		Timestamper timestamper = new Timestamper(privateKey);

		FileInputStream input = new FileInputStream(args[0]);
		byte[] timestampBytes = timestamper.timestamp(input);
		input.close();

		FileOutputStream fos = new FileOutputStream(args[2]);
		fos.write(timestampBytes);
		fos.close();
	}


	// Utility method for converting a long to a byte array.
	private byte[] longToBytes(long longToConvert) {

		byte[] output = new byte[8];
		output[0] = (byte)(longToConvert >>> 56);
		output[1] = (byte)(longToConvert >>> 48);
		output[2] = (byte)(longToConvert >>> 40);
		output[3] = (byte)(longToConvert >>> 32);
		output[4] = (byte)(longToConvert >>> 24);
		output[5] = (byte)(longToConvert >>> 16);
		output[6] = (byte)(longToConvert >>> 8);
		output[7] = (byte)longToConvert;
		return output;
	}
}