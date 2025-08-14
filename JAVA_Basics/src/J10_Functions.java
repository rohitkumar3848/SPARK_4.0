// Topic: Methods in Java
// Definition:
// → A method is a block of code that performs a specific task and can be called when needed.
// → In Java, all functions are written inside a class, hence they are called "methods".
// → Syntax:
//      returnType methodName(parameter1, parameter2, ...) {
//          // method body
//          return value; // if returnType is not void
//      }
//
// Parameters vs Arguments:
// → Parameters = variables defined in method signature (placeholders).
// → Arguments = actual values passed when calling a method.
//
// Types of Methods (based on parameter & return value):
// 1. No parameter, No return value
// 2. With parameter, No return value
// 3. No parameter, With return value
// 4. With parameter, With return value

class J10_Functions {
    public static void main(String[] args) {

        System.out.println("=== Java Methods Demo ===");

        // Creating objects
        J10_Functions m1 = new J10_Functions();
        J10_Functions m2 = new J10_Functions();

        // 1. No parameter, No return
        m1.greet(); // calling greet() method
        m2.greet();

        System.out.println("---------------------");

        // 2. With parameter, No return
        m1.displayName("Rahul", "m1");
        m2.displayName("Simran", "m2");

        System.out.println("---------------------");

        // 3. No parameter, With return
        String otp = m1.otpGen(); // storing returned value
        System.out.println("Generated OTP: " + otp);

        System.out.println("---------------------");

        // 4. With parameter, With return
        int sumValue = m1.sum(10, 10);
        System.out.println("Sum is: " + sumValue);

        System.out.println("---------------------");

        // Static method call (no object needed)
        displayMessage();

        System.out.println("=== End of Demo ===");
    }

    // Type 1: No parameter, No return
    public void greet() {
        System.out.println("Good Morning...");
    }

    // Type 2: With parameter, No return
    public void displayName(String name, String method) {
        System.out.println("Hello " + name + " - " + method);
    }

    // Type 3: No parameter, With return
    public String otpGen() {
        return "1234"; // example fixed OTP
    }

    // Type 4: With parameter, With return
    public int sum(int a, int b) {
        return a + b;
    }

    // Static method example (can be called without object)
    public static void displayMessage() {
        System.out.println("This is a static method!");
    }
}
