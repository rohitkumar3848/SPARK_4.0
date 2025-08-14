
// Constructor: A special method in a class that is automatically called when an object is created.
// It has the same name as the class and no return type (not even void).

class Student {
    String name;
    int age;

    // Default Constructor:
    // A constructor with no parameters. It assigns default values to object properties.
    Student() {
        name = "Unknown";
        age = 0;
    }

    // Parameterized Constructor:
    // A constructor with parameters to initialize object properties with specific values.
    Student(String n, int a) {
        name = n;
        age = a;
    }

    // Copy Constructor:
    // A constructor that creates a new object by copying values from another object.
    Student(Student s) {
        name = s.name;
        age = s.age;
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class J02_Constructor1 {
    public static void main(String[] args) {
        // Using Default Constructor
        Student s1 = new Student();
        s1.display();

        // Using Parameterized Constructor
        Student s2 = new Student("Rohit", 21);
        s2.display();

        // Using Copy Constructor
        Student s3 = new Student(s2);
        s3.display();
    }
}
