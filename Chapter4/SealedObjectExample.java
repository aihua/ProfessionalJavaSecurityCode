import java.io.*;
import javax.crypto.*;
import java.security.*;

public class SealedObjectExample
{
	public static void main (String[] args)
		throws Exception
	{
		String creditCard = "1234567890";

		KeyGenerator keyGenerator = KeyGenerator.getInstance("TripleDES");

		System.out.println("Creating a key.");

		Key key = keyGenerator.generateKey();
		Cipher cipher = Cipher.getInstance("TripleDES");
		cipher.init(Cipher.ENCRYPT_MODE, key);

		System.out.println("Encrypting the object.");
		SealedObject so = new SealedObject(creditCard, cipher);

		System.out.println("Unencrypting the object.");
		String unencryptedCreditCard = (String)so.getObject(key);

		System.out.println("Credit card number: "+unencryptedCreditCard);
	}
}
