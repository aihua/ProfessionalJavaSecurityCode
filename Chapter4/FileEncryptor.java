import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;

/**
 *	This class encrypts and decrypts a file using CipherStreams
 *	and a 256-bit Rijndael key stored in the filesystem.
 */

public class FileEncryptor
{
  private static String KEY_FILENAME="rijndaelkey.bin";
  private static int ITERATIONS=1000;

  public static void main (String[] args)
  throws Exception
  {
    if ((args.length < 2) || (args.length > 4))
    {
      System.err.println("Usage: java CipherStreamExample -c|-e|-d password [inputfile] [outputfile]");
      System.exit(1);
    }

    // Convert the password into a char array
    char[] password = new char[args[1].length()];
    args[1].getChars(0, args[1].length(), password, 0);

    if ("-c".equals(args[0])) createKey(password);
    else if ("-e".equals(args[0])) encrypt(password, args[2], args[3]);
    else if ("-d".equals(args[0])) decrypt(password, args[2], args[3]);
  }

  /**
   *	Creates a 256-bit Rijndael key and stores it to
   *	the filesystem as a KeyStore.
   */
  private static void createKey(char[] password)
  throws Exception
  {
    System.out.println("Generating a Rijndael key...");

    // Create a Rijndael key
    KeyGenerator keyGenerator = KeyGenerator.getInstance("Rijndael");
    keyGenerator.init(256);
    Key key = keyGenerator.generateKey();

    System.out.println("Done generating the key.");

    // Now we need to create the file with the key,
    // encrypting it with a password.
    byte[] salt = new byte[8];
    SecureRandom random = new SecureRandom();
    random.nextBytes(salt);
    PBEKeySpec pbeKeySpec = new PBEKeySpec(password);
    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(
		"PBEWithSHAAndTwofish-CBC");
	SecretKey pbeKey = keyFactory.generateSecret(pbeKeySpec);
	PBEParameterSpec pbeParamSpec = new PBEParameterSpec(salt, ITERATIONS);
	Cipher cipher = Cipher.getInstance("PBEWithSHAAndTwofish-CBC");
	cipher.init(Cipher.ENCRYPT_MODE, pbeKey, pbeParamSpec);

	// Encrypt the key
	byte[] encryptedKeyBytes = cipher.doFinal(key.getEncoded());

	// Write out the salt, and then the encrypted key bytes
	FileOutputStream fos = new FileOutputStream(KEY_FILENAME);
	fos.write(salt);
	fos.write(encryptedKeyBytes);
	fos.close();

  }

  /**
   *	Loads a key from the filesystem
   */
  private static Key loadKey(char[] password)
  throws Exception
  {
	// Load the bytes from the encrypted key file.
    FileInputStream fis = new FileInputStream(KEY_FILENAME);
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    int i = 0;
    while ((i=fis.read()) != -1) {
		baos.write(i);
	}
	fis.close();
	byte[] saltAndKeyBytes = baos.toByteArray();
	baos.close();

	// get the salt, which is the first 8 bytes
	byte[] salt = new byte[8];
	System.arraycopy(saltAndKeyBytes,0,salt,0,8);

	// get the encrypted key bytes
	int length = saltAndKeyBytes.length - 8;
	byte[] encryptedKeyBytes = new byte[length];
	System.arraycopy(saltAndKeyBytes,8,encryptedKeyBytes,0,length);

	// Create the PBE cipher
    PBEKeySpec pbeKeySpec = new PBEKeySpec(password);
    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(
		"PBEWithSHAAndTwofish-CBC");
	SecretKey pbeKey = keyFactory.generateSecret(pbeKeySpec);
	PBEParameterSpec pbeParamSpec = new PBEParameterSpec(salt, ITERATIONS);
	Cipher cipher = Cipher.getInstance("PBEWithSHAAndTwofish-CBC");
	cipher.init(Cipher.DECRYPT_MODE, pbeKey, pbeParamSpec);

	// Decrypt the key bytes
	byte[] decryptedKeyBytes = cipher.doFinal(encryptedKeyBytes);

	// Create the key from the key bytes
	SecretKeySpec key = new SecretKeySpec(decryptedKeyBytes, "Rijndael");
	return key;

  }

  /**
   *	Encrypt a file using Rijndael. Load the key
   *	from the filesystem, given a password.
   */
  private static void encrypt(char[] password, String fileInput, String fileOutput)
  throws Exception
  {
    System.out.println("Loading the key.");
    Key key = loadKey(password);
    System.out.println("Loaded the key.");

    // Create a cipher using that key to initialize it
    Cipher cipher = Cipher.getInstance("Rijndael/CBC/PKCS5Padding");

    System.out.println("Initializing SecureRandom...");

    // Now we need an Initialization Vector for the cipher in CBC mode.
	// We use 16 bytes, because the block size of Rijndael is 256 bits.
    SecureRandom random = new SecureRandom();
    byte[] iv = new byte[16];
    random.nextBytes(iv);

    FileInputStream fis = new FileInputStream(fileInput);
    FileOutputStream fos = new FileOutputStream(fileOutput);

	// Write the IV as the first 16 bytes in the file
    fos.write(iv);
    IvParameterSpec spec = new IvParameterSpec(iv);

    System.out.println("Initializing the cipher.");

    cipher.init(Cipher.ENCRYPT_MODE, key, spec);

    CipherOutputStream cos = new CipherOutputStream(fos, cipher);

    System.out.println("Encrypting the file...");

    int theByte = 0;
    while ((theByte = fis.read()) != -1)
    {
      cos.write(theByte);
    }
    fis.close();
    cos.close();
  }

  /**
   *	Decrypt a file using Rijndael. Load the key
   *	from the filesystem, given a password.
   */
  private static void decrypt(char[] password, String fileInput, String fileOutput)
  throws Exception
  {
    System.out.println("Loading the key.");
    Key key = loadKey(password);
    System.out.println("Loaded the key.");

    // Create a cipher using that key to initialize it
    Cipher cipher = Cipher.getInstance("Rijndael/CBC/PKCS5Padding");

    FileInputStream fis = new FileInputStream(fileInput);
    FileOutputStream fos = new FileOutputStream(fileOutput);

	// Read the IV from the file. It's the first 16 bytes.
    byte[] iv = new byte[16];
    fis.read(iv);

    IvParameterSpec spec = new IvParameterSpec(iv);

    System.out.println("Initializing the cipher.");
    cipher.init(Cipher.DECRYPT_MODE, key, spec);

    CipherInputStream cis = new CipherInputStream(fis, cipher);

    System.out.println("Decrypting the file...");

    int theByte = 0;
    while ((theByte = cis.read()) != -1)
    {
      fos.write(theByte);
    }
    cis.close();
    fos.close();
  }
}