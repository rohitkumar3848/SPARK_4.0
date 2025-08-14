// Topic: Arrays in Java
// Definition: An array is a collection of elements of the same data type stored in contiguous memory locations.
// Features:
// - Fixed size (length is decided at creation).
// - Elements are accessed by index (starting from 0).
// Types:
// 1. Single Dimensional Array (1D)
// 2. Multi-Dimensional Array (2D, 3D, etc.)
// 3. Jagged Arrays (arrays of arrays with different lengths)

class J09_Array {
    public static void main(String[] args) {

        // 1. Declaring & Creating a Single Dimensional Array
        int[] num = new int[5]; // size = 5, default values = 0

        // Assigning values using for loop
        for (int i = 0; i < num.length; i++) {
            num[i] = i * 10; // 0, 10, 20, 30, 40
        }

        // Accessing array elements
        System.out.println("Element at index 3: " + num[3]); // 30

        System.out.println("---------------------");

        // 2. Array Initialization at declaration time
        int[] marks = {85, 90, 78, 92, 88};

        // Traversing using for loop
        System.out.println("Marks using for loop:");
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Index " + i + " = " + marks[i]);
        }

        System.out.println("---------------------");

        // Traversing using for-each loop
        System.out.println("Marks using for-each loop:");
        for (int m : marks) {
            System.out.println(m);
        }

        System.out.println("---------------------");

        // 3. Multi-Dimensional Array (2D array example)
        int[][] matrix = new int[2][3]; // 2 rows, 3 columns

        // Assigning values
        int value = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = value++;
            }
        }

        // Displaying 2D array
        System.out.println("2D Array (Matrix):");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("---------------------");

        // 4. Jagged Array Example (Different column sizes in each row)
        int[][] jagged = new int[3][];
        jagged[0] = new int[2]; // first row with 2 elements
        jagged[1] = new int[4]; // second row with 4 elements
        jagged[2] = new int[3]; // third row with 3 elements

        // Filling jagged array
        int k = 1;
        for (int i = 0; i < jagged.length; i++) {
            for (int j = 0; j < jagged[i].length; j++) {
                jagged[i][j] = k++;
            }
        }

        // Displaying jagged array
        System.out.println("Jagged Array:");
        for (int i = 0; i < jagged.length; i++) {
            for (int j = 0; j < jagged[i].length; j++) {
                System.out.print(jagged[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("---------------------");

        // 5. Common Array property
        System.out.println("Length of marks array: " + marks.length);
        System.out.println("First element in marks: " + marks[0]);
        System.out.println("Last element in marks: " + marks[marks.length - 1]);
    }
}
