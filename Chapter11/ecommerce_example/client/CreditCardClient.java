package ecommerce_example.client;

import ecommerce_example.data.*;
import ecommerce_example.*;
import java.io.*;
import java.security.*;
import java.util.*;
import java.rmi.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

/**
 *	Displays all credit cards in the database,
 *	after decrypting them with a private key.
 */
public class CreditCardClient {

	/**
	  * Given an encrypted credit card's data and the private key, decrypt it
	  * and return a decrypted version.  Essentially unchanged from Chapter 10's
	  * ViewTest
	  */
	private static CreditCard decryptCreditCardDBO( CreditCardDBO ccdbo, PrivateKey privateKey )
		throws UnsupportedEncodingException, InvalidKeyException {

		String creditCardNumber = null;
		try {

			// Decrypt the encrypted session key.
			Cipher asymmetricCipher = Cipher.getInstance( "RSA/ECB/PKCS1Padding" );
			asymmetricCipher.init( Cipher.DECRYPT_MODE, privateKey );
			byte[] sessionKeyBytes = asymmetricCipher.doFinal( ccdbo.getEncryptedSessionKey() );

			// Decrypt the credit card number with the session key.
			SecretKey symmetricKey = new SecretKeySpec( sessionKeyBytes, "Blowfish" );
			Cipher symmetricCipher = Cipher.getInstance( "Blowfish/ECB/PKCS5Padding" );
			symmetricCipher.init( Cipher.DECRYPT_MODE, symmetricKey );
			byte[] ccNumberBytes = symmetricCipher.doFinal( ccdbo.getEncryptedCCNumber() );

			creditCardNumber = new String( ccNumberBytes, "UTF8" );

		// Need to catch a large number of possible exceptions:
		}
		catch (NoSuchAlgorithmException nsae) {
			// Missing an algorithm.
			nsae.printStackTrace();
			throw new RuntimeException("Missing crypto algorithm");
		}
		catch (NoSuchPaddingException nspe) {
			// again, we're in trouble. Missing padding.
			nspe.printStackTrace();
			throw new RuntimeException("Missing Crypto algorithm");
		}
		catch (BadPaddingException bpe) {
			// This means the data is probably bad.
			bpe.printStackTrace();
			throw new InvalidKeyException("Could not decrypt");
		}
		catch (IllegalBlockSizeException ibse) {
			// Probably a bad key.
			ibse.printStackTrace();
			throw new InvalidKeyException("Could not decrypt");
		}

		CreditCard creditCard = new CreditCard( ccdbo.getAccountID(), creditCardNumber );
		return creditCard;
	}

	/**
	  *	Attempts to display all credit cards in the database.  First
	  * command line parameter is the filename of the keystore
	  * containing the private key, second parameter is the password.
	  * In a production environment the user should be prompted each
	  * time for the password
	  */
	public static void main( String[] args ) throws Exception {

		if ( args.length != 1 ) {
			usage();
			System.exit( 1 );
		}

		// Load the keystore to retrieve the private key.
		String ksType = KeyStore.getDefaultType();
		KeyStore ks = KeyStore.getInstance( ksType );
		FileInputStream fis = new FileInputStream( args[ 0 ] );
		//char[] password = args[ 1 ].toCharArray();
		char[] password = getPassword();
		ks.load( fis, password );
		fis.close();
		PrivateKey privateKey = (PrivateKey)ks.getKey( "mykey", password );

		// In order for our SSL sockets to use the keystore, we need
		// the password set.
		System.setProperty("javax.net.ssl.keyStorePassword", new String(password));

		System.out.println("\nGetting the credit cards...\n");

		Bank bank = (Bank)Naming.lookup( "ecommerce_example.Bank" );

		// Get all the credit card account ids
		long ids[] = bank.getAllCreditCardAccountIDs();

		// Decrypt all credit cards, then display them
		for( int i = 0; i < ids.length; i++ ) {
			CreditCardDBO ccdbo = bank.getCreditCardDBO( ids[ i ] );
			CreditCard creditCard = decryptCreditCardDBO( ccdbo, privateKey );
			System.out.println( "\nAccount ID: " + creditCard.getAccountID() );
			System.out.println( "CC Number: " + creditCard.getCreditCardNumber() );
		}

		// Need to manually exit, as the awt event thread would run forever.
		System.exit(0);
	}

	/**
	 *	Create a Swing password dialog box and
	 *	return the password entered.
	 */
	private static char[] getPassword() {
		// dialog is final so that an inner class can access it.
		final JDialog dialog = new JDialog((JFrame)null, "Password", true);

		JLabel passwordLabel = new JLabel("Enter Password:");
		JPasswordField passwordField = new JPasswordField(10);

		dialog.getContentPane().setLayout(new BorderLayout(5, 5));
		dialog.getContentPane().add(passwordLabel, BorderLayout.WEST);
		dialog.getContentPane().add(passwordField, BorderLayout.CENTER);

		// Once someone enters a password, we are done.
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
            }
		});

		dialog.pack();
		// This next call blocks until someone enters a password.
		dialog.setVisible(true);

		char[] password = passwordField.getPassword();
		return password;
	}

	private static void usage() {
		System.out.println( "Usage: java\t-Djava.security.policy=CreditCardClient.policy" );
		System.out.println( "\t\t-Djavax.net.ssl.trustStore=TRUST_STORE_FILE" );
		System.out.println( "\t\t-Djavax.net.ssl.keyStore=KEY_STORE_FILE" );
		System.out.println( "\t\t-Djavax.net.ssl.keyStorePassword=KEY_STORE_PASSWORD" );
		System.out.println( "\t\tecommerce_example.client.CreditCardClient" );
		System.out.println( "\t\tPRIVATE_KEY_KEYSTORE_FILE" );
	}
}