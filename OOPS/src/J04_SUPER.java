
// 'super' keyword in Java
// 1. Refers to immediate parent class object.
// 2. Used to call parent class constructor.
// 3. Used to access parent class methods.
// 4. Used to access parent class variables (when hidden by child).

class Parent {
    String name = "Parent Variable";

    Parent() {
        System.out.println("Parent Constructor");
    }

    void display() {
        System.out.println("Parent Method");
    }
}

class Child extends Parent {
    String name = "Child Variable";

    Child() {
        // Calling parent class constructor
        super();
        System.out.println("Child Constructor");
    }

    void showNames() {
        // Access parent variable
        System.out.println("Parent name: " + super.name);
        // Access child variable
        System.out.println("Child name: " + this.name);
    }

    void callParentMethod() {
        // Call parent class method
        super.display();
    }
}

public class J04_SUPER {
    public static void main(String[] args) {
        Child c = new Child();
        c.showNames();
        c.callParentMethod();
    }
}
