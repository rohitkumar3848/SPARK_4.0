
// Constructor Overloading: 
// Defining multiple constructors in the same class with different parameter lists.
// It allows creating objects in different ways.

class Employee {
    String name;
    int age;

    // Default Constructor
    Employee() {
        name = "Unknown";
        age = 0;
    }

    // Parameterized Constructor (1 parameter)
    Employee(String n) {
        name = n;
        age = 0;
    }

    // Parameterized Constructor (2 parameters)
    Employee(String n, int a) {
        name = n;
        age = a;
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

// Private Constructor:
// A constructor that is declared private. It prevents object creation from outside the class.
// Often used in Singleton Design Pattern.
class Singleton {
    private static Singleton instance;

    // Private constructor → cannot create object using 'new' from outside
    private Singleton() {
        System.out.println("Private Constructor called");
    }

    // Public method to provide single instance
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

public class J02_Constructor2 {
    public static void main(String[] args) {
        // Constructor Overloading in action
        Employee s1 = new Employee();
        Employee s2 = new Employee("Rohit");
        Employee s3 = new Employee("Rohit", 21);

        s1.display();
        s2.display();
        s3.display();

        // Private Constructor usage
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance(); // same instance returned
    }
}
