import java.util.Scanner;
import java.util.Map;
import java.util.InputMismatchException;

public class TemperatureConverter {
  static Scanner scanner = new Scanner(System.in);

  public static void convertTemperature() {
    boolean validUnits = false;
    String units = "";

    while (!validUnits) {
      // Ask user to enter 'f' for Fahrenheit or 'c' for Celsius
      System.out.print("Enter 'f' for Fahrenheit to Celsius or 'c' for Celsius to Fahrenheit: ");
      units = scanner.next().toLowerCase();
      // Check if user entered 'f' or 'c'
      if (units.equalsIgnoreCase("f") || units.equalsIgnoreCase("c")) {
        validUnits = true;
      } else {
        // Handle invalid input
        System.out.println("Invalid input. Please enter 'f' or 'c'.");
        // Remove \n left in input to avoid problems with later inputs
        scanner.nextLine();
      }
    }

    // Initialize a HashMap to store the units and their full names
    Map<String, String> unitNames = Map.of(
        "f", "Fahrenheit",
        "c", "Celsius");

    boolean validInput = false;
    double initial = 0;
    double result = 0;
    String resultingUnits = "";

    while (!validInput) {
      try {
        // Ask user to enter initial temperature
        System.out.println("Enter initial temperature in " + unitNames.get(units) + ": ");
        initial = scanner.nextDouble();
        validInput = true;
      } catch (InputMismatchException ex) {
        // Handle invalid input
        System.out.println("Invalid input. Please enter a number.");
        // Remove \n left in input to avoid problems with later inputs
        scanner.nextLine();
      }
    }

    if (units.equalsIgnoreCase("f")) {
      // Calculate the conversion using the formula: (initial - 32) * 5/9
      result = (initial - 32) * 5 / 9;
      // Switch the units to the c so that the return is the right conversion
      resultingUnits = "c";
    } else if (units.equalsIgnoreCase("c")) {
      // Calculate the conversion using the formula: (initial * 9/5) + 32
      result = (initial * 9 / 5) + 32;
      // Switch the units to the f so that the return is the right conversion
      resultingUnits = "f";
    }

    // Print resulting temperature
    System.out.println("Temperature in " + unitNames.get(resultingUnits) + " is: " + result + '\u00B0' + resultingUnits.toUpperCase());
  }

  public static void main(String[] args) {
    // Call the convertTemperature function
    convertTemperature();
    scanner.close();
  }
}
