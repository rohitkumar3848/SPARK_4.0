/*
==============================================================
            EXCEPTION HANDLING IN JAVA (FULL NOTES + CODE)
==============================================================

▶️ WHAT IS AN EXCEPTION?
An Exception is an unwanted or unexpected event that disturbs the normal flow
of a program. In Java, exceptions occur at **runtime** (not at compile-time).

For example:
int a = 10 / 0;  // This causes ArithmeticException at runtime

==============================================================
▶️ EXCEPTION HIERARCHY

                Throwable
              /           \
         Exception         Error
        /          \
 Checked           Unchecked

→ All exceptions are subclasses of the "Throwable" class.

==============================================================
▶️ TYPES OF EXCEPTIONS

1. CHECKED EXCEPTIONS:
   - Checked at compile-time.
   - Must be handled using try-catch or declared using "throws".
   - Example: IOException, SQLException, FileNotFoundException

2. UNCHECKED EXCEPTIONS:
   - Not checked at compile-time, occur at runtime.
   - Example: NullPointerException, ArithmeticException, ArrayIndexOutOfBoundsException

✅ NOTE:
- All classes under RuntimeException and Error are **unchecked**.
- All remaining are **checked**.

==============================================================
▶️ FULLY CHECKED vs PARTIALLY CHECKED

1. Fully Checked:
   - All child classes are checked.
   - Example: IOException, InterruptedException

2. Partially Checked:
   - Some child classes are unchecked.
   - Example: Exception, Throwable

==============================================================
▶️ CUSTOMIZED EXCEPTION HANDLING USING try-catch

Structure:
try {
   // Risky code
} catch (Exception e) {
   // Handling code
} finally {
   // Cleanup code
}

==============================================================
▶️ METHODS TO PRINT EXCEPTION INFORMATION

1. e.printStackTrace() → Prints exception type + description + stack trace.
2. e.toString() → Prints exception type + description.
3. e.getMessage() → Prints only description.

==============================================================
▶️ MULTIPLE CATCH BLOCKS
We can use multiple catch blocks to handle different types of exceptions differently.

==============================================================
▶️ FINALLY BLOCK
- Used for cleanup code (like closing files, releasing connections).
- Always executes (whether exception occurs or not).
- Exception: Will not execute if System.exit(0) is called.

==============================================================
▶️ return vs finally
Even if return is used in try or catch, finally block executes first.

==============================================================
▶️ DIFFERENCE BETWEEN final, finally, finalize
final → Keyword used with classes, methods, variables.
finally → Block used for cleanup code.
finalize() → Method called by Garbage Collector before destroying object.

==============================================================
▶️ throw vs throws
throw → Used to explicitly throw an exception.
throws → Used in method signature to declare checked exceptions.

==============================================================
*/

import java.io.*;  // For File Handling
        import java.util.Scanner;  // For input

//-------------------------- MAIN CLASS -----------------------------
public class J11_ExceptionHandling {

    public static void main(String[] args) {

        System.out.println("========= EXCEPTION HANDLING DEMO START =========");

        // 1️⃣ Basic try-catch-finally
        basicTryCatch();

        // 2️⃣ Checked Exception Demo (File Not Found)
        checkedExceptionDemo();

        // 3️⃣ Unchecked Exception Demo (NullPointer)
        nullPointerDemo();

        // 4️⃣ Multiple Catch Example
        multipleCatchDemo();

        // 5️⃣ Finally Block Behavior
        finallyDemo();

        // 6️⃣ Return vs Finally
        returnVsFinallyDemo();

        // 7️⃣ throw and throws example
        throwAndThrowsDemo();

        // 8️⃣ Custom Exception Example
        customExceptionDemo();

        // 9️⃣ Exception Stack Trace Example
        exceptionStackTraceDemo();

        System.out.println("========= EXCEPTION HANDLING DEMO END =========");
    }

    // -----------------------------------------------------------
    // 1️⃣ Basic try-catch-finally
    static void basicTryCatch() {
        System.out.println("\n-- Basic try-catch-finally Example --");
        try {
            System.out.println("Before Exception");
            int a = 10 / 0; // Risky code
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: " + e);
        } finally {
            System.out.println("Finally block executed always");
        }
        System.out.println("After handling exception\n");
    }

    // -----------------------------------------------------------
    // 2️⃣ Checked Exception Example
    static void checkedExceptionDemo() {
        System.out.println("-- Checked Exception Example (File Handling) --");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("genie.txt"); // Checked Exception
        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
            System.exit(0); // finally won't execute after this
        } finally {
            System.out.println("Finally block executed (even if file not found)");
        }
    }

    // -----------------------------------------------------------
    // 3️⃣ Unchecked Exception Example (NullPointer)
    static void nullPointerDemo() {
        System.out.println("\n-- Unchecked Exception Example (NullPointer) --");
        String s = null;
        try {
            int len = s.length();
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException");
        }
    }

    // -----------------------------------------------------------
    // 4️⃣ Multiple Catch Example
    static void multipleCatchDemo() {
        System.out.println("\n-- Multiple Catch Example --");
        try {
            int[] arr = {10, 0};
            int result = arr[0] / arr[1]; // Division by zero
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: Division by zero");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException");
        } catch (Exception e) {
            System.out.println("Caught General Exception");
        }
    }

    // -----------------------------------------------------------
    // 5️⃣ Finally Block Example
    static void finallyDemo() {
        System.out.println("\n-- Finally Block Example --");
        try {
            System.out.println("Inside try block");
            System.out.println(10 / 0);
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException");
        } finally {
            System.out.println("Finally block executed (cleanup code)");
        }
    }

    // -----------------------------------------------------------
    // 6️⃣ return vs finally
    static void returnVsFinallyDemo() {
        System.out.println("\n-- Return vs Finally Example --");
        System.out.println("Result returned: " + returnTest());
    }

    static int returnTest() {
        try {
            System.out.println("In try");
            return 10;
        } catch (Exception e) {
            System.out.println("In catch");
            return 20;
        } finally {
            System.out.println("In finally (executes before return)");
            return 30; // finally overrides return
        }
    }

    // -----------------------------------------------------------
    // 7️⃣ throw and throws Example
    static void throwAndThrowsDemo() {
        System.out.println("\n-- throw and throws Example --");
        try {
            divideNumbers(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        try {
            readFile("abc.txt");
        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        }
    }

    static void divideNumbers(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        System.out.println("Result: " + (dividend / divisor));
    }

    static void readFile(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName); // Checked Exception
        fileReader.close();
    }

    // -----------------------------------------------------------
    // 8️⃣ Custom Exception Example
    static void customExceptionDemo() {
        System.out.println("\n-- Custom Exception Example --");
        try {
            withdraw(1000, 2000);
        } catch (InsufficientBalanceException e) {
            System.out.println("Custom Exception: " + e.getMessage());
        }
    }

    static void withdraw(double balance, double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient Balance! Available: " + balance + ", Requested: " + amount);
        }
        System.out.println("Withdrawal successful!");
    }

    // -----------------------------------------------------------
    // 9️⃣ Exception Stack Trace Example (Call Chain)
    static void exceptionStackTraceDemo() {
        System.out.println("\n-- Exception Stack Trace Example --");
        try {
            m1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void m1() {
        m2();
    }

    static void m2() {
        m3();
    }

    static void m3() {
        System.out.println(10 / 0);
    }
}

//-------------------------------------------------------------
// Custom Exception Class
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
