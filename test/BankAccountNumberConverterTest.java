
import bankaccountnumberconverter.Account;
import bankaccountnumberconverter.BankAccountNumberConverter;
import bankaccountnumberconverter.utils.ValidateAccount;
import bankaccountnumberconverter.utils.ValidateBank;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Some tests to verify that the program works as intended.
 * @author tuoma
 */
public class BankAccountNumberConverterTest {

    @Test
    public void testGoodAccountNumbers() {

        String[] bunchOfAccountNumbers = {"123456-785",
            "423456-781",
            "159030-776",
            "405500-1535298",};
        for (int i = 0; i < bunchOfAccountNumbers.length; i++) {
            assertEquals(ValidateAccount.shortAccountNumberIsValid(bunchOfAccountNumbers[i]), true);
            Account acco = new Account(bunchOfAccountNumbers[i]);
            assertEquals(acco.getLongAccountNumber().length(), 14);
            assertEquals(ValidateBank.nameBankByIdentifier(acco.getBankIdentifier()).contains("Not a valid bank!"), false);
        }

    }

    @Test
    public void testBadAccountNumbers() {

        String[] bunchOfBadAccountNumbers = {"123456-785999999",
            "42345-6781",
            "1590307-76",
            "4055001535298",
            "",
            "abc",
            "abc 3425-543",
            "             "
        };
        for (int i = 0; i < bunchOfBadAccountNumbers.length; i++) {
            System.out.println(bunchOfBadAccountNumbers[i] + "..." + ValidateAccount.shortAccountNumberIsValid(bunchOfBadAccountNumbers[i]));
            assertEquals(ValidateAccount.shortAccountNumberIsValid(bunchOfBadAccountNumbers[i]), false);
        }

    }
}
