// Topic: If-Else Conditional Control Statement in Java
// Definition: If-Else statements are used to execute different blocks of code based on a condition.
// Types used in this program:
// 1. Simple if-else → Checks a condition and executes one of the two code blocks.
// 2. If-Else-If Ladder → Multiple conditions are checked in sequence.
// 3. Nested If-Else → An if-else statement inside another if-else statement.

class J06_ControlConditionals {
    public static void main(String[] args) {
        int a = 4; // Amount of money

        System.out.println("babu 10rs ha kya ...?");

        // If-Else-If Ladder + Nested If-Else
        if (a > 10) {
            System.out.println("chal tu khush rah");
            a = a - 10;
            System.out.println("babu 9rs or de do...");

            // Nested If-Else
            if (a > 8) {
                System.out.println("babu 9 paytm krta hu...");
                a = a - 9; // 1
            } else {
                System.out.println("Sorry babu...");
                System.out.println("chal koe bat 5 wali kitkat dila do");

                // Another Nested If-Else
                if (a > 5) {
                    System.out.println("kitkat lelo");
                } else {
                    System.out.println("Koe bat nhi babu main paise de deti hu");
                }
            }
        }
        else if (a > 5) { // Part of If-Else-If Ladder
            System.out.println("bhai 10 nhi ha maire pass");
            System.out.println("Chal 5 hi de de");

            if (a > 5) { // Nested If-Else
                System.out.println("chal bhai tu 5 lele khush rah");
            } else {
                System.out.println("bhai 5 nhi ha maire pass");
            }
        }
        else { // Final Else
            System.out.println("paise hi nhi ha");
        }
    }
}
