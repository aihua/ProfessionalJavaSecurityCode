/**
 *	SSLAuthenticator
 *
 *	Defines an interface for determining if a client
 *	in an SSL session should be allowed
 *	to connect.
 */
public interface SSLAuthenticator {

	public void checkPermission() throws AuthenticationException;
}
