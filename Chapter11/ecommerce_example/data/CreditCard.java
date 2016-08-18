package ecommerce_example.data;

/**
 *  Read-only Credit Card object, unchanged from Chapter 10 except contructor
 * is now public due to different packaging.
 */
public class CreditCard {

    private long mAccountID;
    private String mCreditCardNumber;

    public CreditCard(long accountID, String creditCardNumber) {
        mAccountID = accountID;
        mCreditCardNumber = creditCardNumber;
    }

    public long getAccountID() {
        return mAccountID;
    }

    public String getCreditCardNumber() {
        return mCreditCardNumber;
    }
}
