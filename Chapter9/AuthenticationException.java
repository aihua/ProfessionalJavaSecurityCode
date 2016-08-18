/**
 *	AuthenticationException
 *
 *	Exception to throw if SSL Authentication fails.
 */
public class AuthenticationException extends Exception {

	public AuthenticationException() {
		super();
	}

	public AuthenticationException(String info) {
		super(info);
	}
}
