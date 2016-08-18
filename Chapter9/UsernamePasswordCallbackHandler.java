import java.io.*;
import java.security.*;
import javax.security.auth.*;
import javax.security.auth.callback.*;

/**
 *	CallbackHandler that handles usernames and passwords.
 */
public class UsernamePasswordCallbackHandler
implements CallbackHandler {

	private String mUsername;
	private char[] mPassword;

	/**
	 *	We need a stateful handler to return the username and password.
	 */
	public UsernamePasswordCallbackHandler(String username, char[] password) {
		mUsername = username;
		mPassword = password;
	}

	/**
	 *	Handle each callback. We support only NameCallbacks
	 *	and PasswordCallbacks.
	 */
	public void handle(Callback[] callbacks)
	throws UnsupportedCallbackException {
		// Step through the callbacks
		for(int i=0;i<callbacks.length;i++) {
			Callback callback = callbacks[i];
			// Handle the callback based on its type.
			if (callback instanceof NameCallback) {
				NameCallback nameCallback = (NameCallback)callback;
				nameCallback.setName(mUsername);
			} else if (callback instanceof PasswordCallback) {
				PasswordCallback passwordCallback = (PasswordCallback)callback;
				passwordCallback.setPassword(mPassword);
			} else {
				throw new UnsupportedCallbackException(callback, "Unsupported Callback Type");
			}
		}
	}

}
