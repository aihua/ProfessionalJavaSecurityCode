import java.security.*;
import java.security.cert.*;
import java.io.*;
import java.util.Date;
import java.util.Arrays;

public class TimestampClient {

	// The filename for the certificate of the timestamper.
	private static final String CERTIFICATE_FILENAME = "timestamper.cer";

	// Timestamper's public key.
	private PublicKey mPublicKey;

	private MessageDigest mHasher;
	private Signature mSigner;

	/**
	 *	Create a new instance of TimestampClient.
	 */
	public TimestampClient (PublicKey publicKey) {
		mPublicKey = publicKey;
		try {
			mHasher = MessageDigest.getInstance("SHA-1");
			mSigner = Signature.getInstance("SHA1withRSA");
		} catch (NoSuchAlgorithmException nsae) {
			throw new RuntimeException("Missing algorithm: " + nsae);
		}
	}

	/**
	 *	Checks the timestamp on a given input stream.
	 */
	public boolean checkTimestamp(byte[] timestamp, InputStream input)
		throws SignatureException, IOException {

		// Begin by hashing the input.
		mHasher.reset();
		int i;
		while ((i = input.read())!= -1) {
			mHasher.update((byte)i);
		}
		byte[] hashFromFile = mHasher.digest();

		// Get the hash from the timestamp
		byte[] hash1 = new byte[20];
		System.arraycopy(timestamp,0,hash1,0,20);

		// Compare the hashes
		if (!Arrays.equals(hashFromFile, hash1)) {
			return false;
		}

		// Get the timestamp
		byte[] timeBytes = new byte[8];
		System.arraycopy(timestamp,20,timeBytes,0,8);

		// Convert from bytes to an actual date.
		long time = bytesToLong(timeBytes);
		Date date = new Date(time);

		// Print out the date.
		System.out.println("This data was timestamped on: "+date);

		// Create hash2 from hash1 and the time.
		mHasher.update(hash1);
		mHasher.update(timeBytes);
		byte[] hash2 = mHasher.digest();

		try {
			mSigner.initVerify(mPublicKey);
		} catch (InvalidKeyException ike) {
			throw new SignatureException("Invalid public key");
		}
		mSigner.update(hash2);

		byte[] signatureBytes = new byte[128];
		System.arraycopy(timestamp,28,signatureBytes,0,128);

		// Validate the signature.
		boolean result = mSigner.verify(signatureBytes);

		return result;
	}

	/**
	 *	Check a timestamp on a file.
	 */
	public static void main(String[] args)
		throws Exception {

		if (args.length != 2) {
			System.err.println("Usage: java TimestampClient sourceFilename timestampFilename");
			System.exit(1);
		}

		// Load the timestamp bytes from the timestamp file.
		FileInputStream fis = new FileInputStream(args[1]);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int i;
		while ((i = fis.read()) != -1) {
			baos.write(i);
		}
		byte[] timestampBytes = baos.toByteArray();
		baos.close();
		fis.close();

		// Load the public key from a certificate.
		fis = new FileInputStream(CERTIFICATE_FILENAME);
		CertificateFactory certFactory =
			CertificateFactory.getInstance("X.509");
		java.security.cert.Certificate cert =
			certFactory.generateCertificate(fis);
		fis.close();
		PublicKey publicKey = cert.getPublicKey();

		// Create a client.
		TimestampClient client = new TimestampClient(publicKey);

		FileInputStream input = new FileInputStream(args[0]);
		boolean validTimestamp = client.checkTimestamp(timestampBytes, input);
		input.close();
		System.out.println("Timestamp valid: "+validTimestamp);
	}

	/**
	 *	Converts a byte array to a long.
	 */
	private long bytesToLong(byte[] bytes) {
		long result = 0;
		int tempInt;
		for (int i=0;i<8;i++) {
			result = result << 8;
			tempInt = bytes[i];
			if (tempInt < 0) {
				tempInt = tempInt + 256;
			}
			result = result + tempInt;
		}
		return result;
	}

}
