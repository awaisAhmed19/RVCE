import java.util.Scanner;

// Custom Exception for Age Restriction
class AgeRestrictionException extends Exception {
    public AgeRestrictionException(String message) {
        super(message);
    }
}

// Class containing the verification methods
public class Program6{

    // Method to check age eligibility using throws
    public static void verifyAge(int age) throws AgeRestrictionException, IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative."); // Predefined Exception
        }
        if (age < 18) {
            throw new AgeRestrictionException("Access Denied! You must be at least 18 years old."); // Custom Exception
        }
        System.out.println("Access Granted! You are eligible for the service.");
    }

    // Method to perform division and handle division by zero
    public static double divide(int dividend, int divisor) throws ArithmeticException {
        if (divisor == 0) {
            throw new ArithmeticException("Error: Division by zero is not allowed."); // Predefined Exception
        }
        return (double) dividend / divisor;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Taking age input
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();

            // Checking age criteria
            verifyAge(age);

            // Taking input for division
            System.out.print("Enter dividend: ");
            int dividend = scanner.nextInt();
            System.out.print("Enter divisor: ");
            int divisor = scanner.nextInt();

            // Performing division
            double result = divide(dividend, divisor);
            System.out.println("Result of division: " + result);
        } 
        catch (IllegalArgumentException e) { // Handling predefined exception (Negative age)
            System.out.println("Error: " + e.getMessage());
        } 
        catch (AgeRestrictionException e) { // Handling custom exception (Age restriction)
            System.out.println("Custom Exception: " + e.getMessage());
        } 
        catch (ArithmeticException e) { // Handling predefined exception (Division by zero)
            System.out.println("Error: " + e.getMessage());
        } 
        finally {
            System.out.println("Process completed.");
            scanner.close();
        }
    }
}
