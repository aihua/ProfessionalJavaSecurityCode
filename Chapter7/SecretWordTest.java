public class SecretWordTest {
	public static void main (String[] args) {
		SecretWord secret = new SecretWord();

		// We try to access the secret word. This will
		// throw a SecurityException if we don't have permission
		String theSecretWord = secret.getWord();

		System.out.println("The secret word is: "+theSecretWord);
	}
}