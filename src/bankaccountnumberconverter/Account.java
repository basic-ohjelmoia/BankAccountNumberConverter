
package bankaccountnumberconverter;

import bankaccountnumberconverter.utils.AccountNumberConverter;

/**
 * This is the object for Bank Account.
 * @author tuoma
 */
public class Account {
    
    private String shortAccountNumber;   // short form bank account number
    private String longAccountNumber;    // long form bank account number, i.e. machine readable form
    private int bankIdentifier;          // bank group identifier code
    
    /**
     * Constructor for an account. 
     * @param shortAccountNumber Short form bank account number from which the account object is generated.
     */
    public Account(String shortAccountNumber) {
        this.shortAccountNumber=shortAccountNumber;
        this.bankIdentifier=Integer.parseInt(shortAccountNumber.substring(0,1));
        if (this.bankIdentifier==3) {
            this.bankIdentifier=Integer.parseInt(shortAccountNumber.substring(0,2));
        }
        this.longAccountNumber=AccountNumberConverter.convertShortAccountToLongAccount(this);
    }
    
    
    public String getShortAccountNumber() {
        return this.shortAccountNumber;
    }
    
    public String getLongAccountNumber() {
        return this.longAccountNumber;
    }
    
    public int getBankIdentifier() {
        return this.bankIdentifier;
    }
    
}
