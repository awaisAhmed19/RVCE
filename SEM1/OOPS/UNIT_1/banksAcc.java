import java.util.ArrayList;
import java.util.Scanner;

class Account {
    String accountHolderName;
    String accountType;
    double balance;
    static int totalAccounts = 0; // Static variable to track the number of accounts
    static double totalAmount = 0; // Static variable to track the total balance across all accounts

    // Constructor 1: Only account holder's name (default account type is "Saving" with balance 0)
    public Account(String name) {
        this.accountHolderName = name;
        this.accountType = "Saving";
        this.balance = 0;
        totalAccounts++;
        System.out.println("Account created: Name=" + name + ", Type=Saving, Balance=0");
    }

    // Constructor 2: Name and an initial deposit
    public Account(String name, double initialDeposit) {
        this(name); // Call the first constructor
        if (initialDeposit < 0) {
            throw new IllegalArgumentException("Initial deposit cannot be negative.");
        }
        this.balance = initialDeposit;
        totalAmount += initialDeposit;
        System.out.println("Account created: Name=" + name + ", Type=Saving, Balance=" + initialDeposit);
    }

    // Constructor 3: Name, initial deposit, and account type
    public Account(String name, double initialDeposit, String type) {
        this(name, initialDeposit); // Call the second constructor
        if (!type.equalsIgnoreCase("Saving") && !type.equalsIgnoreCase("Current")) {
            throw new IllegalArgumentException("Invalid account type. Must be 'Saving' or 'Current'.");
        }
        this.accountType = type;
        System.out.println("Account created: Name=" + name + ", Type=" + type + ", Balance=" + initialDeposit);
    }

    // Deposit method 1: Specify only the amount
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        this.balance += amount;
        totalAmount += amount;
        System.out.println("Deposited " + amount + " to " + accountHolderName + "'s account. New balance: " + balance);
    }

    // Deposit method 2: Specify both the amount and transaction type
    public void deposit(double amount, String transactionType) {
        if (!transactionType.equalsIgnoreCase("Cash") && !transactionType.equalsIgnoreCase("Cheque")) {
            throw new IllegalArgumentException("Invalid transaction type. Must be 'Cash' or 'Cheque'.");
        }
        deposit(amount); // Call the first deposit method
        System.out.println("Transaction type: " + transactionType);
    }

    // Static method to display total accounts and total balance
    public static void displaySummary() {
        System.out.println("Total accounts: " + totalAccounts);
        System.out.println("Total balance across all accounts: " + totalAmount);
    }

    // Method to display account details
    public void displayAccount() {
        System.out.println("Name: " + accountHolderName + ", Type: " + accountType + ", Balance: " + balance);
    }
}

// Main class to handle banking app operations
public class BankingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<>();
        
        while (true) {
            System.out.println("\nBanking App Menu:");
            System.out.println("1. Create account (Name only)");
            System.out.println("2. Create account (Name and initial deposit)");
            System.out.println("3. Create account (Name, initial deposit, and account type)");
            System.out.println("4. Deposit money");
            System.out.println("5. Display all accounts");
            System.out.println("6. Display bank summary");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter account holder name: ");
                    String name1 = scanner.nextLine();
                    accounts.add(new Account(name1));
                    break;
                
                case 2:
                    System.out.print("Enter account holder name: ");
                    String name2 = scanner.nextLine();
                    System.out.print("Enter initial deposit: ");
                    double deposit2 = scanner.nextDouble();
                    accounts.add(new Account(name2, deposit2));
                    break;

                case 3:
                    System.out.print("Enter account holder name: ");
                    String name3 = scanner.nextLine();
                    System.out.print("Enter initial deposit: ");
                    double deposit3 = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter account type (Saving/Current): ");
                    String type3 = scanner.nextLine();
                    accounts.add(new Account(name3, deposit3, type3));
                    break;

                case 4:
                    System.out.print("Enter account holder name: ");
                    String depName = scanner.nextLine();
                    boolean accountFound = false;
                    for (Account acc : accounts) {
                        if (acc != null && acc.toString().contains(depName)) {
                            accountFound = true;
                            System.out.print("Enter deposit amount: ");
                            double depAmount = scanner.nextDouble();
                            System.out.print("Enter transaction type (Cash/Cheque or leave empty): ");
                            scanner.nextLine();
                            String depType = scanner.nextLine();
                            if (depType.isEmpty()) {
                                acc.deposit(depAmount);
                            } else {
                                acc.deposit(depAmount, depType);
                            }
                            break;
                        }
                    }
                    if (!accountFound) {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    for (Account acc : accounts) {
                        acc.displayAccount();
                    }
                    break;

                case 6:
                    Account.displaySummary();
                    break;

                case 7:
                    System.out.println("Exiting the Banking App. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
