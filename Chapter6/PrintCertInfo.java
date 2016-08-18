import java.io.*;
import java.security.cert.CertificateFactory;
import java.security.cert.Certificate;

/**
 *	PrintCertInfo
 *
 *	This class creates a Java Certificate object from a DER-encoded
 *	certificate in a file and prints out some basic info about it.
 *
 *	Usage: java PrintCertInfo filename
 */
public class PrintCertInfo {

	public static void main (String[] args) throws Exception {

		if (args.length != 1) {
			System.err.println("Usage: java PrintCertInfo certificateFilename");
			System.exit(1);
		}

		CertificateFactory certFactory = CertificateFactory.getInstance("X.509");

		// Open up a certificate file
		FileInputStream fis = new FileInputStream (args[0]);

		// Generate a certificate from that file
		Certificate cert = certFactory.generateCertificate(fis);
		fis.close();

		// Display general information about the certificate
		System.out.println(cert);
	}
}