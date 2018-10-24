package bankaccountnumberconverter;

import bankaccountnumberconverter.utils.AccountNumberConverter;
import bankaccountnumberconverter.utils.ValidateAccount;
import bankaccountnumberconverter.utils.ValidateBank;

/**
 * This small program can be used to validate BBAN bank account numbers and to
 * convert the short form BBAN bank account numbers into BBAN machine readable
 * (long) form.
 *
 * The program also contains a preliminary Luhn checksum validator, though with
 * such a small dataset of BBAN account numbers available, I'd be reluctant to
 * make any strong claims about the accuracy of my Luhn checksum implementation.
 *
 * @author tuoma
 */
public class BankAccountNumberConverter {

    /**
     * This program will accept command line arguments as bank account numbers
     * which will be verified and converted to machine readable form. If no
     * arguments are given, then the program runs in "demo mode" and makes some
     * default BBAN verifications and conversions.
     *
     * @param args the command line arguments (expects BBAN short form account numbers)
     */
    public static void main(String[] args) {

        String[] bunchOfAccountNumbers = {"123456-785",
            "423456-781",
            "159030-776",
            "405500-1535298",
            "04324f-5434+g",
            "this is not a valid bank account number!"
        };
        if (args.length > 0) {
            bunchOfAccountNumbers = args;
        }

        for (int i = 0; i < bunchOfAccountNumbers.length; i++) {
            String currentAccountNumber = bunchOfAccountNumbers[i];
            boolean shortAccountNumberIsValid = ValidateAccount.shortAccountNumberIsValid(currentAccountNumber);
            System.out.println("Checking if account number {" + currentAccountNumber + "} is valid... " + shortAccountNumberIsValid);
            if (shortAccountNumberIsValid) {
                Account currentAccount = new Account(currentAccountNumber);
                System.out.println("NEW ACCOUNT CREATED");
                System.out.println("Bank detected as: {" + ValidateBank.nameBankByIdentifier(currentAccount.getBankIdentifier()) + "}");
                System.out.println("Account number is machine readable form " + currentAccount.getLongAccountNumber());
                boolean longAccountNumberIsValid = ValidateAccount.matchesLuhnCheckSum(AccountNumberConverter.convertShortAccountToLongAccount(currentAccount));
                System.out.println("Checking if the machine readable account number has a valid Luhn Checksum... " + longAccountNumberIsValid);
            } else {
                System.out.println("ACCOUNT NUMBER IS REJECTED!");
            }
            System.out.println("\n\n");
        }

    }

}
