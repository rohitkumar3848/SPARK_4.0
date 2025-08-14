// Topic: Jump Statements in Java
// Definition: Jump statements are used to transfer control from one part of the program to another.
// Types in Java:
// 1. break → Exits the loop or switch immediately.
// 2. continue → Skips the current iteration and moves to the next iteration.
// 3. return → Exits from the method (and returns a value if required).
// 4. System.exit() → Terminates the entire program immediately.

class J08_JumpStatements {
    public static void main(String[] args) {

        // 1. break statement
        System.out.println("=== break Statement ===");
        for (int i = 1; i <= 10; i++) {
            if (i == 5) { // When i becomes 5, loop will stop
                break;
            }
            System.out.println("Hello World! " + i);
        }

        System.out.println("---------------------");

        // 2. continue statement
        System.out.println("=== continue Statement ===");
        for (int i = 1; i <= 10; i++) {
            if (i == 5) { // When i becomes 5, this iteration is skipped
                continue;
            }
            System.out.println("Hello World! " + i);
        }

        System.out.println("---------------------");

        // 3. return statement
        System.out.println("=== return Statement ===");
        methodWithReturn();
        System.out.println("This line will be printed because method returned normally.");

        System.out.println("---------------------");

        // 4. System.exit() statement
        System.out.println("=== System.exit() Statement ===");
        System.out.println("Before exit");
        // System.exit(0); // Uncommenting this will stop the program here
        System.out.println("After exit (this will not print if System.exit() is called)");
    }

    // Example method for return
    static void methodWithReturn() {
        System.out.println("Inside methodWithReturn");
        if (true) {
            System.out.println("Returning from method...");
            return; // Exits method
        }
        // This line will never be reached
        System.out.println("End of method");
    }
}
