
/*
 * ---------------------------
 *  "this" keyword in Java
 * ---------------------------
 * 1. Refers to the current object inside a method or constructor.
 * 2. Differentiates between local variables and instance (global) variables when they have the same name.
 * 3. Used to call another constructor in the same class (constructor chaining).
 * 4. Can be used to pass the current object as a parameter to another method.
 */

class Demo {
    // Global variables (instance variables)
    String name;
    int age;

    // 1 & 2: Differentiate local and global variables
    Demo(String name, int age) {
        this.name = name; // "this.name" → global var, "name" → local var
        this.age = age;
    }

    // 3: Constructor chaining using "this()"
    Demo() {
        this("Default Name", 0); // Calls parameterized constructor
    }

    // Method to display details
    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    // 4: Passing current object as parameter
    void showDetails(Demo obj) {
        System.out.println("Inside showDetails → Name: " + obj.name);
    }

    void callShowDetails() {
        this.showDetails(this); // Passing current object
    }
}

public class J03_THIS {
    public static void main(String[] args) {
        Demo d1 = new Demo(); // Calls default constructor, which chains to parameterized
        Demo d2 = new Demo("Rohit", 22);

        d1.display();
        d2.display();

        d2.callShowDetails();
    }
}
