
// Encapsulation in Java
// Definition: Encapsulation is the process of wrapping (hiding) the data (variables)
// and methods into a single unit (class), and restricting direct access to the data.
//This is done by:
//        1. Making data members 'private' → So they cannot be accessed directly.
//        2. Providing 'public' getter and setter methods → So we can control access to those data members.
// We provide controlled access using getter and setter methods.
// Benefit: It improves security, reusability, and maintainability of code.

class BankAccount {
    // Private data members (cannot be accessed directly from outside the class)
    private String accountHolder;
    private double balance;

    // Constructor to initialize data
    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Getter method for accountHolder
    public String getAccountHolder() {
        return accountHolder;
    }

    // Setter method for accountHolder
    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    // Getter method for balance
    public double getBalance() {
        return balance;
    }

    // Setter method for balance (with validation)
    public void setBalance(double balance) {
        if (balance >= 0) { // validation check
            this.balance = balance;
        } else {
            System.out.println("Balance cannot be negative.");
        }
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid or insufficient funds.");
        }
    }
}

public class J07_Encapsulation {
    public static void main(String[] args) {
        // Creating object
        BankAccount account = new BankAccount("Rohit Kumar", 5000);

        // Accessing data using getters and setters
        System.out.println("Account Holder: " + account.getAccountHolder());
        System.out.println("Initial Balance: " + account.getBalance());

        // Modifying data safely
        account.deposit(2000);
        account.withdraw(1500);

        // Invalid operation
        account.setBalance(-500); // Won’t allow negative balance

        System.out.println("Final Balance: " + account.getBalance());
    }
}
