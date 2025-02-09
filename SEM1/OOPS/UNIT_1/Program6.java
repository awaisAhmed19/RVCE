import java.util.Scanner;

class AgeRestrictionException extends Exception {
    public AgeRestrictionException(String message) {
        super(message);
    }
}

public class Program6 {

    public static void verifyAge(int age) throws AgeRestrictionException{
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative."); // Predefined Exception
        }
        if (age < 18) {
            throw new AgeRestrictionException("Access Denied! You must be at least 18 years old."); // Custom Exception
        }
        System.out.println("Access Granted! You are eligible for the service.");
    }

    public static double divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Error: Division by zero is not allowed."); // Predefined Exception
        }
        return (double) dividend / divisor;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();

            verifyAge(age);

            System.out.print("Enter dividend: ");
            int dividend = scanner.nextInt();
            System.out.print("Enter divisor: ");
            int divisor = scanner.nextInt();

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
