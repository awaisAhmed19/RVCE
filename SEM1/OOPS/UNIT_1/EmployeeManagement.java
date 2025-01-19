
// Interface for personal information with default methods
interface PersonalInfo {
    void setName(String name);
    void setAge(int age);
    void setAddress(String address);
    
    String getName();
    int getAge();
    String getAddress();

    // Default method for displaying personal information
    default String displayPersonalInfo() {
        return "Name: " + getName() + "\n" +
               "Age: " + getAge() + "\n" +
               "Address: " + getAddress();
    }
}

// Interface for official information with default methods
interface OfficialInfo {
    void setEmployeeId(String employeeId);
    void setDepartment(String department);
    void setSalary(double salary);
    
    String getEmployeeId();
    String getDepartment();
    double getSalary();

    // Default method for displaying official information
    default String displayOfficialInfo() {
        return "Employee ID: " + getEmployeeId() + "\n" +
               "Department: " + getDepartment() + "\n" +
               "Salary: $" + getSalary();
    }
}

// Abstract class for personal details
abstract class Person implements PersonalInfo {
    private String name;
    private int age;
    private String address;  

    @Override
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public void setAge(int age) {
        if (age < 18) {
            System.out.println("Age must be at least 18.");
        } else {
            this.age = age;
        }
    }
    
    @Override
    public void setAddress(String address) {
        this.address = address;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
  @Override
    public int getAge() {
        return age;
    }
    
  @Override
    public String getAddress() {
        return address;
    }
}

// Employee class inheriting from Person and implementing OfficialInfo
class Employee extends Person implements OfficialInfo {
    private String employeeId;
    private String department;
    private double salary;

    @Override
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public void setSalary(double salary) {
        if (salary < 30000) {
            System.out.println("Salary must be at least $30,000.");
        } else {
            this.salary = salary;
        }
    }

    @Override
    public String getEmployeeId() {
        return employeeId;
    }

    @Override
    public String getDepartment() {
        return department;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    // Overriding toString to display complete employee information
    @Override
    public String toString() {
        return "Employee Details:\n" +
               displayPersonalInfo() + "\n" +
               displayOfficialInfo();
    }
}

// Main class to test the implementation
public class EmployeeManagement {
    public static void main(String[] args) {
        // Create an employee object
        Employee emp = new Employee();

        // Set personal information with validation
        emp.setName("Jane Doe");
        emp.setAge(28);
        emp.setAddress("456 Oak Street, Los Angeles");

        // Set official information with validation
        emp.setEmployeeId("E54321");
        emp.setDepartment("Marketing");
        emp.setSalary(50000.00);

        // Display employee details using toString method
        System.out.println(emp);
    }
}
