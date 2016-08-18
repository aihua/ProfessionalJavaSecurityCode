package ecommerce_example.bank;

import ecommerce_example.data.*;
import com.isnetworks.base64.BASE64Encoder;
import com.isnetworks.base64.BASE64Decoder;

import java.io.*;
import java.sql.*;
import java.util.*;

/**
  *	Class for performing database operations.  Now uses the JDBC proxy
	* to encrypt the connection using RMI over SSL and deals with
	* credit cards and accounts separately
  */
public class DatabaseOperations {

	private final static String CREDIT_CARD_INSERT_SQL =
		"INSERT INTO credit_card (account_id, session_key, cc_number) "+
		"VALUES (?,?,?)";

	/**
	  * Added in this chapter
		*/
	private final static String ACCOUNT_INSERT_SQL =
		"INSERT INTO account (account_id, balance, customer_name, cert_serial_number) "+
		"VALUES (?,?,?,?)";

	/**
	  * Added in this chapter
		*/
	private final static String ACCOUNT_SELECT_SQL =
		"SELECT account_id, balance, customer_name FROM account "+
		"WHERE cert_serial_number = ?";

	private final static String CREDIT_CARD_SELECT_SQL =
		"SELECT session_key, cc_number FROM credit_card "+
		"WHERE account_id = ?";

	private final static String CREDIT_CARD_SELECT_IDS_SQL =
		"SELECT account_id FROM credit_card";

	/**
	  * Added in this chapter
		*/
	private final static String ACCOUNT_SELECT_MAX_ID_SQL =
		"SELECT MAX( account_id ) FROM account";

	private Connection mConnection;
	private PreparedStatement mInsertCreditCard;
	private PreparedStatement mInsertAccount;
	private PreparedStatement mSelectAccount;
	private PreparedStatement mSelectCreditCard;
	private PreparedStatement mSelectCreditCardAccountIDs;
	private PreparedStatement mSelectMaxAccountID;
	private BASE64Encoder mEncoder;
	private BASE64Decoder mDecoder;

	/**
	 *	Construct a DatabaseOperations object,
	 *	based on the properties passed in which
	 *	will include url, username, database, and
	 *	JDBC driver name.
	 */
	public DatabaseOperations(Properties properties) {
		// Load our connection and initialize objects.
		mEncoder = new BASE64Encoder();
		mDecoder = new BASE64Decoder();

		String driverName = properties.getProperty("DBDriver");
		String url = properties.getProperty("DBUrl");
		String username = properties.getProperty("DBUsername");
		String password = properties.getProperty("DBPassword");
		try {
			// Load the connection
			Class.forName(driverName);
			mConnection = DriverManager.getConnection
				(url, username, password);
			// Prepare the PreparedStatements.
			mInsertCreditCard = mConnection.prepareStatement
				(CREDIT_CARD_INSERT_SQL);
			mInsertAccount = mConnection.prepareStatement
				(ACCOUNT_INSERT_SQL);
			mSelectAccount = mConnection.prepareStatement
				(ACCOUNT_SELECT_SQL);
			mSelectCreditCard = mConnection.prepareStatement
				(CREDIT_CARD_SELECT_SQL);
			mSelectCreditCardAccountIDs = mConnection.prepareStatement(
				CREDIT_CARD_SELECT_IDS_SQL);
			mSelectMaxAccountID = mConnection.prepareStatement(
				ACCOUNT_SELECT_MAX_ID_SQL);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *	Store a CreditCardDBO object in the database.
	 */
    public void store(CreditCardDBO creditCardDBO)
    	throws IOException {
		try {
			// Need to synchronize to prevent race conditions.
			synchronized(mConnection) {
				mInsertCreditCard.setLong
					(1,creditCardDBO.getAccountID());
				mInsertCreditCard.setString
					(2,mEncoder.encode
					(creditCardDBO.getEncryptedSessionKey()));
				mInsertCreditCard.setString
					(3,mEncoder.encode
					(creditCardDBO.getEncryptedCCNumber()));
				mInsertCreditCard.executeUpdate();
			}
		} catch (SQLException se) {
			se.printStackTrace();
			throw new IOException(se.getMessage());
		}
    }

	/**
	 *	Store an Account object in the database.
	 */
    public void store( Account account )
    	throws IOException {
		try {
			// Need to synchronize to prevent race conditions.
			synchronized(mConnection) {
				mInsertAccount.setLong( 1, account.getAccountID() );
				mInsertAccount.setFloat( 2, account.getBalance() );
				mInsertAccount.setString( 3, account.getCustomerName() );
				mInsertAccount.setString( 4, account.getCertificateSerialNumber() );
				mInsertAccount.executeUpdate();
			}
		} catch (SQLException se) {
			se.printStackTrace();
			throw new IOException(se.getMessage());
		}
    }

	/**
	 *	Creates a CreditCardDBO object with
	 *	data from the database corresponding
	 *	to the client certificate's serial number
	 */
    public Account loadAccount( String certSerialNumber )
    	throws IOException {

		Account account = null;
		try {
			// Need to synchronize to prevent race conditions.
			synchronized(mConnection) {
				mSelectAccount.setString( 1, certSerialNumber );
				ResultSet result = mSelectAccount.executeQuery();
				if ( result.next() ) {
					result.next();

					long accountID = result.getLong( 1 );
					float balance = result.getFloat( 2 );
					String name = result.getString( 3 );

					result.close();
					account = new Account( accountID, balance, name, certSerialNumber );
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
			throw new IOException(se.getMessage());
		}
		return account;
	}

	/**
	 *	Creates a CreditCardDBO object with
	 *	data from the database corresponding
	 *	to the account id passed in.
	 */
    public CreditCardDBO loadCreditCardDBO(long accountID)
    	throws IOException {

		CreditCardDBO creditCardDBO = null;
		try {
			// Need to synchronize to prevent race conditions.
			synchronized(mConnection) {
				mSelectCreditCard.setLong(1,accountID);
				ResultSet result = mSelectCreditCard.executeQuery();
				result.next();
				byte[] encryptedSessionKey = mDecoder.decodeBuffer
					(result.getString(1));
				byte[] encryptedCCNumber = mDecoder.decodeBuffer
					(result.getString(2));
				result.close();
				creditCardDBO = new
					CreditCardDBO
					(accountID, encryptedSessionKey, encryptedCCNumber);
			}
		} catch (SQLException se) {
			se.printStackTrace();
			throw new IOException(se.getMessage());
		}
		return creditCardDBO;
	}

	/**
	 *	Returns the one more than the largest account id value in the database
	 *	Used to determine the number for the next new account
	 */
	public long getMaxAccountID() throws IOException {
		long accountID = 1;
		try {
			synchronized(mConnection) {
				ResultSet result = mSelectMaxAccountID.executeQuery();
				if ( result.next() ) {
					try {
						accountID = result.getLong( 1 );
					}
					catch( Exception e ) {
						// If there's no accounts in the database, use the default value
						// of 1 from above
					}
				}
				result.close();
			}
		}
		catch (SQLException se) {
			se.printStackTrace();
			throw new IOException(se.getMessage());
		}
		return accountID;
	}

	/**
	 *	Returns all the account ids in the database.
	 *	Useful for displaying all credit cards.
	 */
	public long[] getAllCreditCardAccountIDs()
		throws IOException {

		Vector accountIDs = new Vector();
		try {
			synchronized(mConnection) {
				ResultSet result =
					mSelectCreditCardAccountIDs.executeQuery();
				while (result.next()) {
					accountIDs.add(new Long(result.getLong(1)));
				}
				result.close();
			}
		} catch (SQLException se) {
			se.printStackTrace();
			throw new IOException(se.getMessage());
		}
		// convert the vector to an array.
		long[] accountIDArray = new long[accountIDs.size()];
		for (int i=0; i<accountIDArray.length; i++) {
			Long accountIDLong = (Long)accountIDs.elementAt(i);
			accountIDArray[i] = accountIDLong.longValue();
		}
		return accountIDArray;
	}

}
