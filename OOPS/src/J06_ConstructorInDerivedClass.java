
// Constructor in Derived Classes with Parameter Increase
// ------------------------------------------------------
// Definition:
// 1. In inheritance, constructors are NOT inherited, but they are called in a chain.
// 2. When an object of a derived class is created, the base class constructor is executed first.
// 3. We can use 'super()' to call the parent class constructor.
// 4. In parameterized form, parameters can be increased at each inheritance level.

class Base {
    // Default Constructor
    Base() {
        System.out.println("Base Class Default Constructor");
    }

    // Parameterized Constructor (1 parameter)
    Base(int a) {
        System.out.println("Base Class Parameterized Constructor: a = " + a);
    }
}

class Child1 extends Base {
    // Default Constructor
    Child1() {
        super(); // Calls Base default constructor
        System.out.println("Child1 Class Default Constructor");
    }

    // Parameterized Constructor (2 parameters)
    Child1(int a, int b) {
        super(a); // Calls Base parameterized constructor
        System.out.println("Child1 Class Parameterized Constructor: b = " + b);
    }
}

class GrandChild1 extends Child1 {
    // Default Constructor
    GrandChild1() {
        super(); // Calls Child1 default constructor (which calls Base default)
        System.out.println("GrandChild1 Class Default Constructor");
    }

    // Parameterized Constructor (3 parameters)
    GrandChild1(int a, int b, int c) {
        super(a, b); // Calls Child1 parameterized constructor (which calls Base parameterized)
        System.out.println("GrandChild1 Class Parameterized Constructor: c = " + c);
    }
}

public class J06_ConstructorInDerivedClass {
    public static void main(String[] args) {
        System.out.println("=== Default Constructor Call ===");
        GrandChild1 gc1 = new GrandChild1();

        System.out.println("\n=== Parameterized Constructor Call ===");
        GrandChild1 gc2 = new GrandChild1(10, 20, 30);
    }
}
