
// ===================== INTERFACES IN JAVA =====================
// 🔹 Definition:
// An interface in Java is a blueprint of a class. It contains abstract methods (by default public and abstract),
// static methods, default methods (Java 8+), and constants (public static final).
// It is used to achieve abstraction and multiple inheritance in Java.

// ===================== WHY INTERFACE SUPPORTS MULTIPLE INHERITANCE =====================
// A class can implement multiple interfaces because interfaces only provide method declarations
// (no state / instance variables). This avoids the diamond problem present in multiple class inheritance.

// ===================== TYPES =====================
// 1. Normal Interface (multiple abstract methods allowed before Java 8)
// 2. Functional Interface (only 1 abstract method — supports Lambda Expressions)
// 3. Marker Interface (empty — used for tagging classes, e.g., Serializable)

// ===================== JAVA 8 FEATURES OVER INTERFACE =====================
// 1. Default methods (method with body inside interface, not forcing implementation)
// 2. Static methods (can be called using interface name)
// 3. Functional Interface + Lambda Expressions

// ===== NORMAL INTERFACE =====
interface MyInterface {
    void method1();
    void method2();
}

// ===== MARKER INTERFACE =====
interface MarkerInterface { } // Empty interface (tagging purpose)

// ===== FUNCTIONAL INTERFACE =====
@FunctionalInterface
interface MyFunctional {
    void greet(String name); // Only 1 abstract method allowed
    default void defaultMethod() {
        System.out.println("Default method in functional interface");
    }
    static void staticMethod() {
        System.out.println("Static method in functional interface");
    }
}

// ===== INTERFACE INHERITANCE =====
interface ParentInterface {
    void parentMethod();
}
interface ChildInterface extends ParentInterface {
    void childMethod();
}

// ===== CLASS IMPLEMENTING MULTIPLE INTERFACES =====
class MyClass implements MyInterface, ChildInterface {
    @Override
    public void method1() {
        System.out.println("Method1 implemented");
    }
    @Override
    public void method2() {
        System.out.println("Method2 implemented");
    }
    @Override
    public void parentMethod() {
        System.out.println("Parent method implemented");
    }
    @Override
    public void childMethod() {
        System.out.println("Child method implemented");
    }
}

// ===== OUTER & INNER CLASSES =====
class Outer {
    // Non-static Inner Class
    class Inner {
        void display() {
            System.out.println("Inside Non-static Inner Class");
        }
    }

    // Static Inner Class
    static class StaticInner {
        void show() {
            System.out.println("Inside Static Inner Class");
        }
    }
}

public class J09_Interface {
    public static void main(String[] args) {

        // ===== Using Normal Interface Implementation =====
        MyClass obj = new MyClass();
        obj.method1();
        obj.method2();
        obj.parentMethod();
        obj.childMethod();

        // ===== LAMBDA EXPRESSION =====
        // Since MyFunctional is functional interface, we can use lambda
        MyFunctional lambdaObj = (name) -> System.out.println("Hi " + name + " from Lambda!");
        lambdaObj.greet("Simran");
        lambdaObj.defaultMethod();
        MyFunctional.staticMethod();

        // ===== ANONYMOUS INNER CLASS =====
        MyFunctional anonObj = new MyFunctional() {
            @Override
            public void greet(String name) {
                System.out.println("Hello " + name + " from Anonymous Inner Class");
            }
        };
        anonObj.greet("Rahul");

        // ===== INNER CLASS EXAMPLE =====
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner(); // Non-static inner
        inner.display();

        Outer.StaticInner staticInner = new Outer.StaticInner(); // Static inner
        staticInner.show();

        // ===== Marker Interface Example =====
        if (obj instanceof MarkerInterface) {
            System.out.println("This object is marked!");
        } else {
            System.out.println("This object is NOT marked!");
        }
    }
}

/*
===================== KEY POINTS =====================
1. Interfaces provide abstraction & multiple inheritance.
2. Functional Interfaces enable Lambda expressions.
3. Marker Interfaces are used for tagging.
4. Default & Static methods added in Java 8.
5. Anonymous Inner Class: Implementation without a named class.
6. Inner Class Types:
   - Non-static Inner Class (needs outer object)
   - Static Inner Class (no outer object needed)
*/
