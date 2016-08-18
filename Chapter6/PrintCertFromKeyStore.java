import java.io.*;
import java.security.cert.CertificateFactory;
import java.security.cert.Certificate;
import java.security.KeyStore;

/**
 *	PrintCertInfo
 *
 *	This class creates a Java Certificate object from a DER-encoded
 *	certificate in a file and prints out some basic info about it.
 *
 *	Usage: java PrintCertInfo filename
 */
public class PrintCertFromKeyStore {

	public static void main (String[] args) throws Exception {

		if (args.length != 2) {
			System.err.println("Usage: java PrintCertInfo alias password");
			System.exit(1);
		}

		// The default keystore is in the user's home directory.
		String userHome = System.getProperty("user.home");
		String keystoreFilename = userHome + File.separator + ".keystore";

		char[] password = args[1].toCharArray();

		String alias = args[0];

		// Open the keystore file
		FileInputStream fIn = new FileInputStream(keystoreFilename);
		KeyStore keystore = KeyStore.getInstance("JKS");

		// Load the keystore from that file.
		keystore.load(fIn, password);

		// Fetch the certificate.
		Certificate cert = keystore.getCertificate(alias);

		// Display general information about the certificate
		System.out.println(cert);
	}
}