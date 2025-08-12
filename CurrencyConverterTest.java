import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CurrencyConverterTest {

    // Helper method to capture the console output of the CurrencyConverter
    private String runConverter(String[] args) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        CurrencyConverter.main(args);

        return outputStream.toString();
    }

    // Test: Case when no arguments are provided
    @Test
    public void testNoArguments() {
        String[] args = {};
        String output = runConverter(args);

        // Ensure the program outputs an error message
        assertTrue(output.contains("Please provide the correct amount and currency type"));
    }

    // Test: Case when the input arguments are in wrong order
    @Test
    public void testWrongArgumentOrder() {
        String[] args = {"dollars", "50"};
        String output = runConverter(args);

        // Ensure the program outputs an error message for wrong argument order
        assertTrue(output.contains("Please provide the correct amount and currency type"));
    }

    // Test: Case when the currency type is in all caps
    @Test
    public void testUpperCaseCurrency() {
        String[] args = {"50", "POUNDS"};
        String output = runConverter(args);

        // Ensure the conversion happens for upper case currency input
        assertTrue(output.contains("50 Pounds ="));
    }

    // Test: Case when the currency type is capitalized
    @Test
    public void testCapitalizedCurrency() {
        String[] args = {"50", "Dollars"};
        String output = runConverter(args);

        // Ensure the conversion happens for capitalized currency input
        assertTrue(output.contains("50 Dollars ="));
    }

    // Test: Case when the currency type is in all lowercase
    @Test
    public void testLowerCaseCurrency() {
        String[] args = {"50", "euros"};
        String output = runConverter(args);

        // Ensure the conversion happens for lowercase currency input
        assertTrue(output.contains("50 Euros ="));
    }

    // Test: Verify conversion of 50 dollars to pounds and euros
    @Test
    public void testDollarConversion() {
        String[] args = {"50", "dollars"};
        String output = runConverter(args);

        // Check if the conversion to pounds and euros is correct based on the given rates
        assertTrue(output.contains("50 Dollars = 37.0 Pounds"));
        assertTrue(output.contains("50 Dollars = 44.0 Euros"));
    }

    // Test: Verify conversion of 50 pounds to dollars and euros
    @Test
    public void testPoundConversion() {
        String[] args = {"50", "pounds"};
        String output = runConverter(args);

        // Check if the conversion to dollars and euros is correct based on the given rates
        assertTrue(output.contains("50 Pounds = 68.0 Dollars"));
        assertTrue(output.contains("50 Pound = 59.5 Euros"));
    }

    // Test: Verify conversion of 50 euros to dollars and pounds
    @Test
    public void testEuroConversion() {
        String[] args = {"50", "euros"};
        String output = runConverter(args);

        // Check if the conversion to dollars and pounds is correct based on the given rates
        assertTrue(output.contains("50 Euros = 65.5 Dollars"));
        assertTrue(output.contains("50 Euros = 42.0 Pounds"));
    }
}
