package ecommerce_example.data;

import java.io.*;

/**
  * Class to wrap up all of the user-entered information on the
	* registration page
	*/

public class RegistrationInformation implements Serializable {
	private String mName;
	
	private String mCertificateSerialNumber;
	
	private String mCreditCardNumber;
	
	private float mBalance;
	
	public RegistrationInformation( String name, String certSerialNumber, String creditCardNumber, float balance ) {
		mName = name;
		mCertificateSerialNumber = certSerialNumber;
		mCreditCardNumber = creditCardNumber;
		mBalance = balance;
	}
	
	public String getName() {
		return mName;
	}
	
	public String getCertificateSerialNumber() {
		return mCertificateSerialNumber;
	}
	
	public String getCreditCardNumber() {
		return mCreditCardNumber;
	}
	
	public float getBalance() {
		return mBalance;
	}
}