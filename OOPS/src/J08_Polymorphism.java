
/*
    POLYMORPHISM:
    ----------------
    Definition:
    "Polymorphism" means "many forms".
    In OOP, it refers to the ability of the same function/method name to behave differently
    based on the object or parameters.

    In Java, there are TWO main types:

    1. STATIC POLYMORPHISM (Compile-Time)
       - Achieved using METHOD OVERLOADING.
       - Which method is called is decided at COMPILE time.
       - Java does NOT support true Operator Overloading (like C++).
         But internally '+' works for both numbers and strings (this is built-in).

    2. DYNAMIC POLYMORPHISM (Run-Time)
       - Achieved using METHOD OVERRIDING.
       - Which method is called is decided at RUN time (Dynamic Dispatch).
       - Requires INHERITANCE and OVERRIDING.

    EXTRA:
    --------
    - Upcasting: Referring to a child object with a parent reference.
      This is commonly used in dynamic polymorphism to decide method calls at runtime.
*/

class Calculator {

    // ===== STATIC POLYMORPHISM =====
    // Method Overloading - Same name, different parameter list
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public String add(String a, String b) {
        return a + b; // '+' here is internally an example of operator overloading handled by Java
    }
}

// ===== DYNAMIC POLYMORPHISM =====
class Animal1 {
    public void sound() {
        System.out.println("Animal1 makes a sound");
    }
}

class Dog1 extends Animal1 {
    @Override
    public void sound() {
        System.out.println("Dog1 barks");
    }
}

class Cat1 extends Animal1 {
    @Override
    public void sound() {
        System.out.println("Cat1 meows");
    }
}

public class J08_Polymorphism {
    public static void main(String[] args) {

        // ===== Static Polymorphism Example =====
        Calculator calc = new Calculator();
        System.out.println(calc.add(2, 3));         // Calls int version
        System.out.println(calc.add(2.5, 3.5));     // Calls double version
        System.out.println(calc.add("Hello ", "World")); // Calls String version

        // ===== Dynamic Polymorphism Example =====
        Animal1 a1 = new Dog1(); // Upcasting: Parent ref, child object
        Animal1 a2 = new Cat1(); // Upcasting again

        a1.sound(); // Decided at runtime -> Dog1's version
        a2.sound(); // Decided at runtime -> Cat1's version

        // Direct reference
        Dog1 d1 = new Dog1();
        d1.sound(); // Dog1's version

        // Upcasting Demonstration
        Animal1 myAnimal1 = new Dog1(); // Upcasting
        myAnimal1.sound(); // Calls Dog1's overridden method due to runtime binding
    }
}

/*
    NOTE:
    - Static Polymorphism = Compile-time (Method Overloading)
    - Dynamic Polymorphism = Runtime (Method Overriding)
    - Upcasting allows runtime method selection (Dynamic Dispatch)
*/
