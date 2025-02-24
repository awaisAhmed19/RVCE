/*
 *write a program to implement the following requirements
create a class named Storage that can store and retrieve objects  of any types
USe a type parameter <T> to ensure the class can handle multiple data types
create a generic method named print array that can print the element of any types of arrays 
Use a type parameter <E> to handle various data types (eg,. arrays of Integers String or character)

Step1: Define a Generics class
Create a class Strorage with a type parameter<T>
Add a private field to store an object of type T
Provide method to store SetItem and retieve getItem the object

Step2:
Define a generic method
Create a static generic method printArray that accept an array of a generic type<E>,
Use a loop to print each element of the array

Step3:
Instantiate the storage class for different data type
Use the SetItem anf getItem methods to store and retirieve values
Use the printArray method to display arrays of different datatypes


 * */


class Storage<T> {
    private T item;
    
    public void setItem(T item) {
        this.item = item;
    }
    
    public T getItem() {
        return item;
    }
}

class GenericMethods {
    public static <E> void printArray(E[] array) {
        for (E element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

public class prog9{
    public static void main(String[] args) {
        // Step 3: Instantiate Storage with different data types
        Storage<Integer> intStorage = new Storage<>();
        Storage<String> stringStorage = new Storage<>();

        // Store and retrieve values
        intStorage.setItem(100);
        stringStorage.setItem("Hello Generics");
        
        System.out.println("Stored Integer: " + intStorage.getItem());
        System.out.println("Stored String: " + stringStorage.getItem());

        // Using the generic method printArray
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"Java", "Generics", "Example"};
        Character[] charArray = {'A', 'B', 'C'};
        
        System.out.println("Integer Array:");
        GenericMethods.printArray(intArray);
        
        System.out.println("String Array:");
        GenericMethods.printArray(strArray);
        
        System.out.println("Character Array:");
        GenericMethods.printArray(charArray);
    }
}
