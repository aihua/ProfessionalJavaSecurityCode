import javax.security.auth.*;
import javax.security.auth.login.*;

import java.security.*;

public class JAASSampleApp extends Object {

	public static void main(String[] args)
	throws Exception {
		if (args.length != 2) {
			System.err.println
				("Usage: java JAASSampleApp username password");
			System.exit(1);
		}

		String username = args[0];
		char[] password = args[1].toCharArray();
		LoginContext loginContext = new LoginContext(
			"Sample", new UsernamePasswordCallbackHandler
				(username, password));

		loginContext.login();

		// Now we're logged in, so we can get the current subject.
		Subject subject = loginContext.getSubject();

		// Display the subject
		System.out.println(subject);
	}
}
