/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccountnumberconverter.utils;

import bankaccountnumberconverter.Account;
import bankaccountnumberconverter.Account;
import bankaccountnumberconverter.utils.ValidateBank;

/**
 * This utility class is used to generate the machine readable long form BBAN account number.
 *
 * @author tuoma
 */
public class AccountNumberConverter {
    
    /**
     * As the name implies, this method will convert a short form account number into the long form.
     * IMPORTANT: This method is designed to read verified short form BBAN numbers. It should be never parametrized with invalid/unverified account numbers!
     * @param account The account object containing a verified short form BBAN account number.
     * @return Returns the long form machine readable BBAN account number as a STRING.
     */
    public static String convertShortAccountToLongAccount(Account account) {
        
        StringBuilder shortAccount = new StringBuilder();
        shortAccount.append(account.getShortAccountNumber());
        shortAccount.deleteCharAt(shortAccount.lastIndexOf("-"));
        
        int cutOffPoint = ValidateBank.getCutOffPoint(account.getBankIdentifier());
        
        StringBuilder longAccount = new StringBuilder();
        StringBuilder longAccountEnding = new StringBuilder();
        
        longAccount.append(shortAccount.substring(0, cutOffPoint));
        longAccountEnding.append(shortAccount.substring(cutOffPoint));
        
        for (int i = cutOffPoint+1; i<cutOffPoint-shortAccount.length()+15; i++) {
            longAccount.append("0");
        }
        longAccount.append(longAccountEnding);
        
        return longAccount.toString();
    }
    
}
