//write a java program to create an abstract c;ass printer and implement all the method using the concrete class 

//step1: create a abstract class called the printer with the methods like configuration and display
//step2: create two concrete class "Dot-matrix" and laser-jet, implement the abstreacr class printer and its method with respect to the abstreacr class

//step3: A main class with a menu derivn for implementing the abstraction

//expected output:
//the program should display the details of the dot matrix and laserjet class details with an implementation of the abstract class

//runtime polymorphism
//example prpogram that showcases runtime []
import java.util.*;

// Step 1: Abstract Printer class
abstract class Printer {
    // Abstract methods
    public abstract void configuration();
    public abstract void display();
}

// Concrete class 1: DotMatrix Printer
class DotMatrix extends Printer {
    @Override
    public void configuration() {
        System.out.println("DotMatrix Printer Configuration: 9 pins, 80 characters per line.");
    }

    @Override
    public void display() {
        System.out.println("DotMatrix Printer Display: Low-quality printing with noise.");
    }
}

// Concrete class 2: LaserJet Printer
class LaserJet extends Printer {
    @Override
    public void configuration() {
        System.out.println("LaserJet Printer Configuration: 1200 DPI, Color printing.");
    }

    @Override
    public void display() {
        System.out.println("LaserJet Printer Display: High-quality, fast, and silent printing.");
    }
}

// Step 3: Main class to implement runtime polymorphism
public class Abstraction{
    public static void main(String[] args) {
        // Create a menu for the user to choose which printer to use
        System.out.println("Choose a printer:");
        System.out.println("1. DotMatrix Printer");
        System.out.println("2. LaserJet Printer");

        // Create a scanner object for user input
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        // Create a reference of Printer type
        Printer printer = null;

        // Step 4: Based on the choice, instantiate the appropriate Printer class
        switch (choice) {
            case 1:
                printer = new DotMatrix();
                break;
            case 2:
                printer = new LaserJet();
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        // Step 5: Display printer details using polymorphism
        System.out.println("\nPrinter Details: ");
        printer.configuration();  // Calls the configuration method of the chosen printer
        printer.display();        // Calls the display method of the chosen printer
    }
}
