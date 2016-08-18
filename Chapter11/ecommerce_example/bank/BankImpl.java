package ecommerce_example.bank;

import ecommerce_example.*;
import ecommerce_example.data.*;
import com.isnetworks.crypto.rmi.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.io.*;
import java.util.*;
import java.rmi.*;

/**
  * Creates or retrieves Account objects
  * This is a modified version of the CreditCardFactory from Chapter 10.  It
  * has been changed to make it work over RMI and handle both account
  * and credit card information
  */
public class BankImpl extends java.rmi.server.UnicastRemoteObject implements Bank {

	/**
	  * Socket to use for RMI connections.  Set explicitly so that
	  * policy file can grant permission to that port only.
	  */
	private static final int SERVER_SOCKET_PORT = 16547;

	/**
	  * Some garbage value to denote that the next account id is not yet known
	  */
	private static final long UNKNOWN_ACCOUNT_ID = Long.MIN_VALUE;

	/**
	  * Maximum account id in use
	  */
	private long mMaxAccountID = UNKNOWN_ACCOUNT_ID;

	/**
	  * Key to use to encrypt all new credit cards before going to the database
	  */
	private PublicKey mPublicKey;

	/**
	  * Handles all database calls
	  */
	private DatabaseOperations mDBOperations;

	/**
	 *	Creates a new instance of BankImpl
	 *	using a Properties object to establish where the public
	 *	key is, as well as the database properties are.
	 */
	public BankImpl( Properties properties ) throws IOException {
		super( SERVER_SOCKET_PORT, new RMISSLClientSocketFactory(), new RMISSLServerSocketFactory() );

		String certFilename = properties.getProperty("PublicKeyFilename");
		try {
			// Get the public key
			FileInputStream fis = new FileInputStream(certFilename);
			java.security.cert.CertificateFactory cf =
				java.security.cert.CertificateFactory.getInstance
				("X.509");
			java.security.cert.Certificate cert =
				cf.generateCertificate(fis);
			fis.close();
			mPublicKey = cert.getPublicKey();
		} catch (Exception e) {
			e.printStackTrace();
			throw new IOException(e.getMessage());
		}
		// Create a new DatabaseOperations instance for
		// database calls.
		mDBOperations = new DatabaseOperations(properties);
	}


	/**
	 *	Create a credit card from an account id, a credit
	 *	card number, and a public key.
	 *
	 *	Automatically encrypts the card and stores it in
	 *	the database.
	 */
	public Account register( RegistrationInformation registrationInfo )
		throws InvalidKeyException, IOException, RemoteException {

		Account account = null;
		CreditCardDBO creditCardDBO = null;
		byte[] encryptedSessionKey, encryptedCCNumber;

		try {
			// Create a blowfish key and encrypt the credit card number.
			KeyGenerator kg = KeyGenerator.getInstance( "Blowfish" );
			kg.init( 128 );
			Key sessionKey = kg.generateKey( );

			Cipher symmetricCipher = Cipher.getInstance( "Blowfish/ECB/PKCS5Padding" );
			symmetricCipher.init( Cipher.ENCRYPT_MODE, sessionKey );
			encryptedCCNumber = symmetricCipher.doFinal( registrationInfo.getCreditCardNumber().getBytes( "UTF8" ) );

			// Use the public key to encrypt the session key.
			Cipher asymmetricCipher = Cipher.getInstance( "RSA/ECB/PKCS1Padding" );
			asymmetricCipher.init( Cipher.ENCRYPT_MODE, mPublicKey );
			encryptedSessionKey = asymmetricCipher.doFinal( sessionKey.getEncoded() );

		// Need to catch a large number of possible exceptions:
		}
		catch( NoSuchAlgorithmException nsae ) {
			// We're in trouble. Missing RSA or Blowfish.
			nsae.printStackTrace();
			throw new RuntimeException( "Missing Crypto algorithm" );
		}
		catch( NoSuchPaddingException nspe ) {
			// again, we're in trouble. Missing padding.
			nspe.printStackTrace();
			throw new RuntimeException( "Missing Crypto algorithm" );
		}
		catch( BadPaddingException bpe ) {
			// Probably a bad key.
			bpe.printStackTrace();
			throw new InvalidKeyException( "Missing Crypto algorithm" );
		}
		catch(IllegalBlockSizeException ibse) {
			// Probably a bad key.
			ibse.printStackTrace();
			throw new InvalidKeyException( "Could not encrypt" );
		}

		long accountID = getNextAccountID();

		// Create a database object with the encrypted info.
		creditCardDBO = new CreditCardDBO( accountID, encryptedSessionKey, encryptedCCNumber );

		// Store the encrypted credit card in the database
		mDBOperations.store( creditCardDBO );
		account = new Account( accountID, registrationInfo.getBalance(), registrationInfo.getName(), registrationInfo.getCertificateSerialNumber() );
		mDBOperations.store( account );

		return account;
	}

	/**
	  * If there is a known value of the highest account id, add one and return it.
	  * Otherwise, look in the database for the highest account id and return it.
	  */
	private long getNextAccountID() throws IOException {
		if ( mMaxAccountID == UNKNOWN_ACCOUNT_ID ) {
			mMaxAccountID = mDBOperations.getMaxAccountID();
		}

		mMaxAccountID++;
		return mMaxAccountID;
	}

	/**
	  * Look up an account by the client certificate's serial number, returning
	  * null if they don't have and account yet
      */
	public Account getAccount( String certSerialNumber ) throws RemoteException {
		try {
			Account account = mDBOperations.loadAccount( certSerialNumber );
			return account;
		}
		catch( IOException e ) {
			throw new RemoteException( e.getMessage() );
		}
	}

	/**
	  * Go to the database and get an array of all the account numbers
	  * currently stored
	  */
	public long[] getAllCreditCardAccountIDs() throws RemoteException {
		try {
			return mDBOperations.getAllCreditCardAccountIDs();
		}
		catch( IOException e ) {
			throw new RemoteException( e.getMessage() );
		}
	}

	/**
	  * Given an account id, find an encrypted credit card object
	  * Changed from Chapter 16 so that the private key can be stored
	  * on a machine other than the RMI middleware server
	  */
	public CreditCardDBO getCreditCardDBO( long accountID ) throws RemoteException {
		try {
			return mDBOperations.loadCreditCardDBO( accountID );
		}
		catch( IOException e ) {
			throw new RemoteException( e.getMessage() );
		}
	}
}
