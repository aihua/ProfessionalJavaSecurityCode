import java.security.*;
import java.util.*;
import javax.security.auth.*;
import javax.security.auth.login.*;

public class JAASAuthorizationExample {

	private static final String GENERIC_SECRET_TEXT = "secret word";
	private static final String TEST_USER_SECRET_TEXT = "squeamish ossifrage";

	/**
	 *	We return a different string based on the user.
	 */
	public static String getSecretText() {

		AccessControlContext context = AccessController.getContext();
		Subject subject = Subject.getSubject(context);

		if (subject == null) {
			return GENERIC_SECRET_TEXT;
		}

		// Get all the principals that are instances of our PrincipalImpl class.
		Set principals = subject.getPrincipals();
		Iterator iterator = principals.iterator();
		while (iterator.hasNext()) {
			PrincipalImpl principal = (PrincipalImpl)iterator.next();
			if (principal.getName().equals("testuser")) {
				return TEST_USER_SECRET_TEXT;
			}
		}
		return GENERIC_SECRET_TEXT;
	}

	/**
	 *	Try to log a user in and then run ExampleAction.
	 */
	public static void main(String[] args) {
		if (args.length != 2) {
			System.err.println
			("Usage: java JAASSampleApp username password");
			System.exit(1);
		}

		LoginContext loginContext = null;

		String username = args[0];
		char[] password = args[1].toCharArray();

		try {
			loginContext = new LoginContext(
				"Sample", new UsernamePasswordCallbackHandler
				(username, password));
			loginContext.login();
			System.out.println("\nLogin succeeded");
		} catch (LoginException le) {
			System.out.println("\nLogin failed");
		}

		// Now we're logged in, so we can get the current subject.
		Subject subject = loginContext.getSubject();

		// Perform the example action as the authenticated subject.
		subject.doAs(subject, new ExampleAction());
	}
}


class ExampleAction implements PrivilegedAction {

	public ExampleAction() {
	}

	public Object run() {
		System.out.println("Secret text: " + JAASAuthorizationExample.getSecretText());
		return null;
	}
}