import java.security.*;
import javax.crypto.*;

public class KeysizeTest
{
	public static void main (String[] args)
		throws Exception
	{
		KeyGenerator keygen = KeyGenerator.getInstance("Blowfish");
		keygen.init(128);
		Key key = keygen.generateKey();

		byte[] keyBytes = key.getEncoded();

		System.out.println(keyBytes.length);
	}
}