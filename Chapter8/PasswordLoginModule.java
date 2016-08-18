import javax.security.auth.*;
import javax.security.auth.spi.*;
import javax.security.auth.callback.*;
import javax.security.auth.login.*;

import java.io.*;
import java.security.*;
import java.util.*;


/**
 *	Login module that checks a username and password.
 */
public class PasswordLoginModule implements LoginModule {
	
	private Subject mSubject;
	private CallbackHandler mCallbackHandler;
	
	private boolean mLoginSucceeded = false;
	private boolean mCommitSucceeded = false;
	
	private String mUsername;
	private char[] mPassword;
	
	private Principal mPrincipal;
	
	/**
	 *	Initialize this login module.
	 */
	public void initialize(Subject subject,CallbackHandler callbackHandler,
		Map sharedState,Map options) {
			mSubject = subject;
			mCallbackHandler = callbackHandler;
			mLoginSucceeded = false;
			mCommitSucceeded = false;
			mUsername = null;
			clearPassword();
			// We do not support shared state or options in this simple example.
	}
	
	/**
	 *	Attempt to log a user in.
	 *	
	 *	In this sample, we accept:
	 *	username: "testuser"
	 *	password: "sasquatch"
	 */
	public boolean login() throws LoginException {
		if (mCallbackHandler == null) {
			throw new LoginException("No CallbackHandler defined");
		}
		
		// create two callbacks: one for username, one for password.
		Callback[] callbacks = new Callback[2];
		callbacks[0] = new NameCallback("Username");
		callbacks[1] = new PasswordCallback("Password", false);
		
		try {
			// Call the callback handler to fill out information
			mCallbackHandler.handle(callbacks);
			mUsername = ((NameCallback)callbacks[0]).getName();
			char[] tempPassword = ((PasswordCallback)callbacks[1]).getPassword();
			mPassword = new char[tempPassword.length];
			System.arraycopy(tempPassword, 0, mPassword, 0, tempPassword.length);
			// Clear out the password in the callback
			((PasswordCallback)callbacks[1]).clearPassword();
		} catch (IOException ioe) {
			throw new LoginException(ioe.toString());
		} catch (UnsupportedCallbackException uce) {
			throw new LoginException(uce.toString());
		}
		
		// Now we need to check for the validity of the username and password.
		// If we were using a database or a file, we would check against
		// that resource.
		if (
			"testuser".equals(mUsername) && 
			mPassword.length == 9 &&
			mPassword[0] == 's' &&
			mPassword[1] == 'a' &&
			mPassword[2] == 's' &&
			mPassword[3] == 'q' &&
			mPassword[4] == 'u' &&
			mPassword[5] == 'a' &&
			mPassword[6] == 't' &&
			mPassword[7] == 'c' &&
			mPassword[8] == 'h'
			) {
				
			// username and password are correct.
			mLoginSucceeded = true;
			return true;
		} else {
			// Authentication failed. Clean up state and throw exception.
			mLoginSucceeded = false;
			mUsername = null;
			clearPassword();
			throw new FailedLoginException("Incorrect Password");
		}
	}
	
	/**
	 *	This is called if all logins succeeded. 
	 */
	public boolean commit() throws LoginException {
		if (mLoginSucceeded == false) {
			return false;
		}
		// Login succeeded, so create a Principal and add it to the Subject.
		mPrincipal = new PrincipalImpl(mUsername);
		if (!(mSubject.getPrincipals().contains(mPrincipal))) {
			mSubject.getPrincipals().add(mPrincipal);
		}
		
		// If we wanted our Subject to contain our credentials,
		// now would be the time to add them. We don't need to
		// do that for this simple example however.
		
		// Clear out the username and password.
		mUsername = null;
		clearPassword();
		mCommitSucceeded = true;
		return true;
	}
	
	/**
	 *	Called if overall login failed.
	 */
	public boolean abort() throws LoginException {
		// If login failed, return false;
		if (mLoginSucceeded == false) {
			return false;
		} else if (mLoginSucceeded == true && mCommitSucceeded == false) {
			// Our login succeeded, but others failed.
			mLoginSucceeded = false;
			mUsername = null;
			clearPassword();
			mPrincipal = null;
		} else {
			// We committed, but someone else's failed.
			logout();
		}
		return true;
	}
	
	/**
	 *	Logout the user.
	 */
	public boolean logout() throws LoginException {
		// Need to remove the principal from the Subject.
		mSubject.getPrincipals().remove(mPrincipal);
		mLoginSucceeded = false;
		mCommitSucceeded = false;
		mUsername = null;
		clearPassword();
		mPrincipal = null;
		return true;
	}
	
	/**
	 *	Clear out the password.
	 */
	private void clearPassword() {
		if (mPassword == null) {
			return;
		}
		for (int i=0;i<mPassword.length;i++) {
			mPassword[i] = ' ';
		}
		mPassword = null;
	}
	
}
