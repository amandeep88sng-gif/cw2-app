import java.util.*;
import java.text.DecimalFormat;

public class CurrencyConverter {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Please provide a value and a currency type (e.g., 50 dollars).");
            return;
        }

        double amount;
        try {
            amount = Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount format. Please provide a valid number.");
            return;
        }

        String currency = args[1].toLowerCase(); // Normalize currency to lowercase

        DecimalFormat f = new DecimalFormat("##.##");
        double dollar, pound, euro;

        switch (currency) {
            case "dollars":
                pound = amount * 0.74;
                euro = amount * 0.88;
                System.out.println(amount + " Dollars = " + f.format(pound) + " Pounds");
                System.out.println(amount + " Dollars = " + f.format(euro) + " Euros");
                break;

            case "pounds":
                dollar = amount * 1.36;
                euro = amount * 1.19;
                System.out.println(amount + " Pounds = " + f.format(dollar) + " Dollars");
                System.out.println(amount + " Pounds = " + f.format(euro) + " Euros");
                break;

            case "euros":
                dollar = amount * 1.13;
                pound = amount * 0.84;
                System.out.println(amount + " Euros = " + f.format(dollar) + " Dollars");
                System.out.println(amount + " Euros = " + f.format(pound) + " Pounds");
                break;

            default:
                System.out.println("Invalid currency type. Please enter 'dollars', 'pounds', or 'euros'.");
                break;
        }

        System.out.println("Thank you for using the converter.");
    }
}
