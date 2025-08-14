
// OOPs (Object-Oriented Programming System) is a programming paradigm
// that organizes code into objects, which combine data (variables) and
// methods (functions) into a single unit (class).

// Class: A blueprint or template to create objects.
// Object: An instance of a class; it has its own copy of variables and can use the class methods.

class Car {
    // Data members (variables) - properties of the object
    String color;
    String brand;

    // Method - behavior of the object
    void displayInfo() {
        System.out.println("Brand: " + brand + ", Color: " + color);
    }
}

public class J01_ClassANDObject {
    public static void main(String[] args) {
        // Creating first object of Car
        Car car1 = new Car(); // Object creation
        car1.brand = "Tesla";
        car1.color = "Red";
        car1.displayInfo();

        // Creating second object of Car
        Car car2 = new Car();
        car2.brand = "BMW";
        car2.color = "Black";
        car2.displayInfo();
    }
}

