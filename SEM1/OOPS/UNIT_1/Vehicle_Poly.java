// Interface Vehicle
interface Vehicle {
    void start();  // Method to be implemented by all vehicles
}

// Concrete class Car
class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car is starting");
    }
}

// Concrete class Bike
class Bike implements Vehicle {
    @Override
    public void start() {
        System.out.println("Bike is starting");
    }
}

// Main class to demonstrate runtime polymorphism with Vehicle interface
public class Vehicle_Poly{
    public static void main(String[] args) {
        // Create references of type Vehicle
        Vehicle vehicle1 = new Car();  // Vehicle reference, but Car object
        Vehicle vehicle2 = new Bike(); // Vehicle reference, but Bike object

        // Demonstrate runtime polymorphism
        vehicle1.start();  // Calls Car's start()
        vehicle2.start();  // Calls Bike's start()
    }
}
