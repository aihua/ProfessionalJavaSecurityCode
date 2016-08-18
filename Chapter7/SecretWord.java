import java.security.*;

public class SecretWord {

	private static final String mTheSecretWord = "ossifrage";

	public SecretWord() {
		super();
	}

	public String getWord() {
		// Try to get the SecurityManager
		SecurityManager security = System.getSecurityManager();
		if (security != null) {
			// Check to see if we have permission to read the word
			security.checkPermission(new SecretWordPermission("AccessPermission"));
		}
		return mTheSecretWord;
	}
}