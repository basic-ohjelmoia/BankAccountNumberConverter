/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccountnumberconverter.utils;

/**
 * This utility class is used to verify wether the bank identifier number inside the account number is valid.
 * @author tuoma
 */
public class ValidateBank {

    
    /**
     * Checks whether the identifier can be matched with an actual bank/bank group name.
     * @param bankIdentifier Bank identifier number being checked.
     * @return Returns TRUE if a bank was identified.
     */
    public static boolean validateBankByIdentifier(int bankIdentifier) {
        
        if (nameBankByIdentifier(bankIdentifier).contains("Not a valid bank!")) {
            return false;
        } else {
            return true;
        }
    }
    
    /**
     * This method will return the bank/bank group name based on the bank identifier.
     * @param bankIdentifier Bank identifier number
     * @return Return a bank name, or an error message.
     */
    public static String nameBankByIdentifier(int bankIdentifier) {

        switch (bankIdentifier) {
            case 1:
                return "Nordea Pankki (Nordea)";
            case 2:
                return "Nordea Pankki (Nordea)";
            case 31:
                return "Handelsbanken (SHB)";
            case 33:
                return "Skandinaviska Enskilda Banken (SEB)";
            case 34:
                return "Danske Bank";
            case 36:
                return "Tapiola Pankki (Tapiola)";
            case 37:
                return "DnB NOR Bank ASA (DnB NOR)";
            case 38:
                return "Swedbank";
            case 39:
                return "S-Pankki";
            case 4:
                return "säästöpankit (Sp) ja paikallisosuuspankit (Pop) sekä Aktia";
            case 5:
                return "osuuspankit (Op), OKO ja Okopankki";
            case 6:
                return "Ålandsbanken ÅAB)";
            case 8:
                return "Sampo Pankki (Sampo)";
        }

        return "Not a valid bank!";
        
    }

    /**
     * This method will return the cut-off point used generate the long form BBAN account number.
     * The cut-off point is based on the bank identifier number.
     * @param bankIdentifier bank identifier
     * @return returns the cut-off point based on the bank identifier
     */
    public static int getCutOffPoint(int bankIdentifier) {

        if (bankIdentifier == 4 || bankIdentifier == 5) {
            return 7;
        } else {
            return 6;
        }

    }

}
