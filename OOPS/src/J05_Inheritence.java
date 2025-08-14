
/*
-------------------------------------------------
Inheritance in Java
-------------------------------------------------
Definition:
Inheritance is a mechanism in OOP where one class (child/subclass) acquires
properties and methods from another class (parent/superclass).

Benefits:
- Code Reusability
- Method Overriding (Polymorphism)
- Easy Maintenance

-------------------------------------------------
Types of Inheritance in Java:
-------------------------------------------------
1. Single Inheritance:
   - One class inherits from another.
   - Example: Class B extends Class A.

2. Multilevel Inheritance:
   - A class inherits from another class, which itself inherits from another class.
   - Example: C -> B -> A

3. Hierarchical Inheritance:
   - Multiple classes inherit from a single class.
   - Example: B and C inherit from A.

4. Hybrid Inheritance:
   - Combination of two or more types (NOT directly supported in Java using classes).
   - Achieved via interfaces.

-------------------------------------------------
Multiple Inheritance in Java:
-------------------------------------------------
- Not supported with classes to avoid ambiguity (Diamond Problem).
- Supported via interfaces.

-------------------------------------------------
Types of Methods in Inheritance:
-------------------------------------------------
1. Inherited Methods:
   - Methods from parent class available in child without changes.

2. Overridden Methods:
   - Child class provides its own implementation for a parent method.

3. Specialized Methods:
   - Methods defined only in child class (not in parent).
*/

// -------------------- Single Inheritance --------------------
class Animal {
    void eat() { System.out.println("Animal is eating..."); } // Inherited Method
}

class Dog extends Animal {
    void bark() { System.out.println("Dog is barking..."); } // Specialized Method
    @Override
    void eat() { // Overridden Method
        System.out.println("Dog eats meat...");
    }
}

// -------------------- Multilevel Inheritance --------------------
class BabyDog extends Dog {
    void weep() { System.out.println("BabyDog is weeping..."); }
}

// -------------------- Hierarchical Inheritance --------------------
class Cat extends Animal {
    void meow() { System.out.println("Cat is meowing..."); }
}

// -------------------- Hybrid Inheritance via Interfaces --------------------
interface Pet {
    void friendly();
}

class PetDog extends Dog implements Pet {
    public void friendly() {
        System.out.println("PetDog is friendly!");
    }
}

public class J05_Inheritence {
    public static void main(String[] args) {
        // Single Inheritance
        Dog d = new Dog();
        d.eat();   // Overridden
        d.bark();  // Specialized

        // Multilevel Inheritance
        BabyDog bd = new BabyDog();
        bd.eat();
        bd.bark();
        bd.weep();

        // Hierarchical Inheritance
        Cat c = new Cat();
        c.eat();
        c.meow();

        // Hybrid Inheritance
        PetDog pd = new PetDog();
        pd.eat();
        pd.friendly();
    }
}
