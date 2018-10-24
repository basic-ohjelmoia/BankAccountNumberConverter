/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccountnumberconverter.utils;

/**
 * This utility class is used to verify the validity of the account numbers being processed.
 * @author tuoma
 */
public class ValidateAccount {

    /**
     * This method is used to verify wether a short form BBAN number can be
     * considered as formally valid. A malformed account number shouldn't be
     * used to create Account objects!
     *
     * @param shortAccountNumber Short form BBAN account number being tested
     * @return Returns TRUE if the account number is formally correct.
     */
    public static boolean shortAccountNumberIsValid(String shortAccountNumber) {
        if (!shortAccountNumber.matches("^[0-9]{6}[-]{1}[0-9]{2,8}$")) {
            System.out.println("The account number didn't match the regex!");
            return false;
        }

        StringBuilder structuredAccount = new StringBuilder(shortAccountNumber);

        if (structuredAccount.charAt(6) != '-') {

            System.out.println("The account number is missing or misplacing the dash-sign!");
            return false;
        }

        if (structuredAccount.substring(7).length() < 2 || structuredAccount.substring(7).length() > 8) {
            System.out.println("The account number is not properly formatted!");
            return false;
        }
        return true;
    }

    /**
     * This method tries to verify wether the long form BBAN account number has
     * a correct Luhn checksum. The accuracy of this method should not be
     * considered as verified, as it has only been tested against a limited
     * number of 'real' BBAN account numbers.
     *
     * @param longAccountNumber Long form BBAN account number being validated.
     * @return Returns TRUE if the calculated Luhn checksum matches the actual
     * checksum number of the account.
     */
    public static boolean matchesLuhnCheckSum(String longAccountNumber) {

        String luhnNumbers = "";

        for (int i = longAccountNumber.length() - 2; i >= 0; i--) {
            luhnNumbers = luhnNumbers + ((((i + 1) % 2) + 1) * Integer.parseInt("" + longAccountNumber.charAt(i)));
            //     System.out.println("index: "+i+", luhn now: "+luhnNumbers+" to which was added {"+((i%2)+1)+"} * "+longAccountNumber.charAt(i));
        }
        int luhnSum = 0;
        for (int j = 0; j < luhnNumbers.length(); j++) {
            //     System.out.println("sum index: "+j+" adding: "+luhnNumbers.charAt(j));
            luhnSum += Integer.parseInt("" + luhnNumbers.charAt(j));
        }

        int calculatedChecksum = (10 - (luhnSum % 10));
        if (calculatedChecksum == 10) {
            calculatedChecksum = 0;
        }

        System.out.println("The Luhn checksum was calculated as: " + calculatedChecksum + " while the account number contains a Luhn checksum of: " + longAccountNumber.charAt(13));

        return calculatedChecksum == Integer.parseInt("" + longAccountNumber.charAt(13));

    }

}
