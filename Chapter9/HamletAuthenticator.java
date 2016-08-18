import javax.net.ssl.*;
import javax.security.cert.*;

/**
 *	HamletAuthenticator
 *
 *	This class is an implementation of the SSLAuthenticator
 *	interface, and provides a mechanism for checking that the
 *	certificate used in SSLAuthentication is for an entity
 *	with the Common Name of Hamlet.
 *
 *	Note that in the setup of the SSL Server, care should be taken
 *	to only allow specific CAs that will check the identity of an
 *	entity before granting a certificate with the Common Name of
 *	Hamlet.
 */
public class HamletAuthenticator implements SSLAuthenticator {

	private SSLSession mSession;

	public HamletAuthenticator (SSLSession session) {
		mSession = session;
	}

	public void checkPermission() throws AuthenticationException {

	System.out.println(mSession.getCipherSuite());

		X509Certificate[] certChain = null;
		try {
			// Get the cert chain
			certChain = mSession.getPeerCertificateChain();
		} catch (SSLPeerUnverifiedException spue) {
			// There isn't one!
			throw new AuthenticationException("Peer unverified");
		}
		// Get the client's certificate
		X509Certificate clientCert = certChain[0];
		// Get the Principal corresponding to the client
		java.security.Principal client = clientCert.getSubjectDN();
		// Get the name of the client
		String name = client.getName();

		// The name should start with "CN=Hamlet,". If not,
		// the user should not be allowed in.
		if (name.indexOf("CN=Hamlet,")!=0) {
			throw new AuthenticationException("Peer is not Hamlet");
		}

		//System.out.println("Client name: " + name);
	}
}
