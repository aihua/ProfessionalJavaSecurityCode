package ecommerce_example;

import java.rmi.*;
import java.io.*;
import java.security.*;
import ecommerce_example.data.*;

/**
 * RMI interface that allows servlets and the credit card client to connect
 * over RMI to create and access account and credit card information
 */
public interface Bank extends Remote {
	/**
	  * Register a new account given some basic user information
		*/
	public Account register( RegistrationInformation info )
		throws RemoteException, IOException, InvalidKeyException;

	/**
	  * Find the Account for a given client cert serial number
		*/
	public Account getAccount( String certSerialNumber )
		throws RemoteException;

	/**
	  * Fetch the encrypted credit card information for a given account id
		*/
	public CreditCardDBO getCreditCardDBO( long accountID )
		throws RemoteException;

	/**
	  * Get a list of all the account ids in the database
		*/
	public long[] getAllCreditCardAccountIDs()
		throws RemoteException;
}