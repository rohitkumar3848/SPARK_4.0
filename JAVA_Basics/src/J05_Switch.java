// Topic: Switch Statement in Java
// Definition: Switch statement is used to execute one block of code among multiple options
// based on the value of a variable or expression. It is an alternative to using multiple if-else statements.

import java.util.Scanner;

class J05_Switch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the n value = ");
        int n = sc.nextInt();

        // Switch statement to check the value of 'n'
        switch(n) {
            case 1:
                System.out.println("value is 1");
                break;
            case 2:
                System.out.println("value is 2");
                break;
            case 3:
                System.out.println("value is 3");
                break;
            default:
                System.out.println("not Exist");
        }
    }
}
