

// ========================== ABSTRACTION DEMO ==========================
/*
    ABSTRACTION:
    ------------
    - Hiding implementation details and showing only essential features.
    - Achieved using ABSTRACT CLASS and INTERFACE in Java.
    - Helps in designing a template for subclasses.
    - Promotes code reusability, flexibility, and security.

    ABSTRACT CLASS PROPERTIES:
    --------------------------
    1. Declared with 'abstract' keyword.
    2. Can have abstract (without body) and concrete (with body) methods.
    3. Can have constructors, variables, static methods.
    4. Cannot be instantiated directly — needs subclass.
    5. Can implement interfaces.
    6. Supports single inheritance.

    ABSTRACT METHOD:
    ----------------
    - Declared without body.
    - Must be implemented by subclass unless subclass is also abstract.
*/

abstract class Vehicle {
    String brand;

    // Constructor
    Vehicle(String brand) {
        this.brand = brand;
    }

    // Abstract method (no body)
    abstract void start();

    // Concrete method
    void displayBrand() {
        System.out.println("Brand: " + brand);
    }
}

// ===== CHILD CLASS 1 =====
class Car1 extends Vehicle {
    int seats;

    Car1(String brand, int seats) {
        super(brand);
        this.seats = seats;
    }

    @Override
    void start() {
        System.out.println("Car1 starts with key ignition");
    }
}

// ===== CHILD CLASS 2 =====
class Bike extends Vehicle {
    Bike(String brand) {
        super(brand);
    }

    @Override
    void start() {
        System.out.println("Bike starts with self start button");
    }
}

/*
    INTERFACE:
    ----------
    - 100% abstraction (before Java 8).
    - All methods are public abstract by default (Java 7-).
    - Variables are public static final by default.
    - Supports multiple inheritance.
    - Cannot have constructors.
    - From Java 8: Can have default & static methods.
*/
interface Flyable {
    void fly(); // public abstract by default

    default void checkWings() {
        System.out.println("Wings checked and ready!");
    }

    static void fuelCheck() {
        System.out.println("Fuel checked for flying vehicle!");
    }
}

// ===== CLASS IMPLEMENTING INTERFACE =====
class Plane extends Vehicle implements Flyable {
    Plane(String brand) {
        super(brand);
    }

    @Override
    void start() {
        System.out.println("Plane starts with runway acceleration");
    }

    @Override
    public void fly() {
        System.out.println("Plane is flying at 30,000 feet");
    }
}

public class J10_Abstraction {
    public static void main(String[] args) {

        // ===== Using Abstract Class =====
        Vehicle v1 = new Car1("Toyota", 4);
        v1.displayBrand();
        v1.start();

        Vehicle v2 = new Bike("Yamaha");
        v2.displayBrand();
        v2.start();

        // ===== Using Interface =====
        Plane p = new Plane("Boeing");
        p.displayBrand();
        p.start();
        p.checkWings(); // default method from interface
        p.fly();
        Flyable.fuelCheck(); // static method from interface
    }
}

/*
    ABSTRACT CLASS vs INTERFACE:
    ----------------------------
    1. Methods:
       - Abstract Class: Can have abstract & concrete methods.
       - Interface: All abstract by default (Java 7-), Java 8+ can have default & static methods.

    2. Variables:
       - Abstract Class: Can have instance & static variables.
       - Interface: Only public static final.

    3. Constructors:
       - Abstract Class: Yes.
       - Interface: No.

    4. Inheritance:
       - Abstract Class: Single inheritance.
       - Interface: Multiple inheritance.

    5. Usage:
       - Abstract Class: When classes share common state/behavior + need to enforce methods.
       - Interface: When only method signatures need to be defined and multiple inheritance is required.
*/
