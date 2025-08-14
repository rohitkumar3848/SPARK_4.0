// Topic: Loops in Java
// Definition: Loops are control flow statements used to execute a block of code repeatedly until a specified condition is met.
// Types of Loops in Java:
// 1. For Loop → Executes a block of code for a fixed number of iterations.
// 2. While Loop → Executes a block of code while the condition is true (condition is checked before each iteration).
// 3. Do-While Loop → Executes the block at least once, then repeats while the condition is true (condition is checked after each iteration).
// 4. For-Each Loop → Used to iterate through elements of arrays/collections directly without using an index.

class J07_Loops {
    public static void main(String[] args) {

        // 1. For Loop
        System.out.println("=== For Loop ===");
        for (int i = 0; i < 5; i++) {
            System.out.println("Vikas " + i);
        }

        System.out.println("---------------------");

        // 2. While Loop
        System.out.println("=== While Loop ===");
        int count = 0;
        while (count < 5) {
            System.out.println("Count: " + count);
            count++;
        }

        System.out.println("---------------------");

        // 3. Do-While Loop
        System.out.println("=== Do-While Loop ===");
        int a = 1;
        do {
            System.out.println("Hello buddy");
            a++;
        } while (a <= 3); // Runs at least once

        System.out.println("---------------------");

        // 4. For-Each Loop
        System.out.println("=== For-Each Loop ===");
        String[] names = {"Rohit", "Vikas", "Amit", "Priya"};
        for (String name : names) {
            System.out.println("Name: " + name);
        }
    }
}
