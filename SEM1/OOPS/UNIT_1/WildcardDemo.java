import java.util.ArrayList;
import java.util.List;

public class WildcardDemo {

    public static void readOnlyList(List<? extends Number> list) {
        System.out.println("Reading from list with upper-bound wildcard:");
        for (Number num : list) {
            System.out.println(num);
        }
    }

    public static void addElements(List<? super Integer> list) {
        System.out.println("\nAdding Integers to a list with lower-bound wildcard:");
        list.add(100);
        list.add(200);
        list.add(300);

        for (Object obj : list) {
            System.out.println(obj);
        }
    }

    public static void printAnyType(List<?> list) {
        System.out.println("\nPrinting any type of list:");
        for (Object obj : list) {
            System.out.println(obj);
        }
    }

    public static void removeAll(List<?> list) {
        System.out.println("\nRemoving all elements from the list:");
        list.clear();
        System.out.println("List cleared.");
    }

    public static void mixTypes(List<Object> list) {
        System.out.println("\nMixing different types in the same list:");
        list.add(42);               
        list.add(3.14);              
        list.add("Mixed Type List"); 

        for (Object obj : list) {
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(10);
        intList.add(20);
        intList.add(30);
        readOnlyList(intList); 

        List<Number> numberList = new ArrayList<>();
        numberList.add(50.5);
        numberList.add(75);
        addElements(numberList); 

        List<String> stringList = new ArrayList<>();
        stringList.add("Hello");
        stringList.add("World");
        printAnyType(stringList);

        removeAll(stringList);
        printAnyType(stringList);  

        List<Object> mixedList = new ArrayList<>();
        mixTypes(mixedList);  
    }
}
