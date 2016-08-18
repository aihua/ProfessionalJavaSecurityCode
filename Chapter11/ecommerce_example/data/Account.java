package ecommerce_example.data;

import ecommerce_example.*;
import java.io.*;

/**
 * Simple class to hold account information in the database, which is not
 * encrypted.  Each variable maps to a database field.
 */
public class Account implements Serializable {

	/**
	  * Unique identifier - primary key in database
		*/
	private long mAccountID;

	private float mBalance;

	private String mCustomerName;

	/**
	  * Serial number for the browser's certificate
		*/
	private String mCertificateSerialNumber;

	public Account( long accountID, float balance, String customerName, String certSerialNumber ) {
		mAccountID = accountID;
		mBalance = balance;
		mCustomerName = customerName;
		mCertificateSerialNumber = certSerialNumber;
	}

	public long getAccountID() {
		return mAccountID;
	}

	public float getBalance() {
		return mBalance;
	}

	public String getCustomerName() {
		return mCustomerName;
	}

	public String getCertificateSerialNumber() {
		return mCertificateSerialNumber;
	}
}