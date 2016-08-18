package ecommerce_example.data;

 /**
  * Credit Card DataBase Object
  *
  * Read-only credit card object for holding information pulled directly from
  * the database.
  *
  * Unchanged from Chapter 10
  */
  public class CreditCardDBO implements java.io.Serializable {

      private long mAccountID;
      private byte[] mEncryptedSessionKey;
      private byte[] mEncryptedCCNumber;

      public CreditCardDBO(long accountID, byte[] encryptedSessionKey,
      	byte[] encryptedCCNumber) {
          mAccountID = accountID;
          mEncryptedSessionKey = encryptedSessionKey;
          mEncryptedCCNumber = encryptedCCNumber;
      }

      public long getAccountID() {
          return mAccountID;
      }

      public byte[] getEncryptedSessionKey() {
          return mEncryptedSessionKey;
      }

      public byte[] getEncryptedCCNumber() {
          return mEncryptedCCNumber;
      }
 }
