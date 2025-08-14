class J04_Operators {
    public static void main(String[] args) {

        // 1. Arithmetic Operators
        int a = 10;
        int b = 2;
        System.out.println("Arithmetic Operators:");
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));
        System.out.println("a % b = " + (a % b));

        System.out.println("---------------------");

        // 2. Unary Operators
        int u = 5;
        System.out.println("Unary Operators:");
        System.out.println("+u = " + (+u)); // unary plus
        System.out.println("-u = " + (-u)); // unary minus
        System.out.println("u++ = " + (u++)); // post increment
        System.out.println("++u = " + (++u)); // pre increment
        System.out.println("u-- = " + (u--)); // post decrement
        System.out.println("--u = " + (--u)); // pre decrement
        System.out.println("~u = " + (~u));   // bitwise NOT
        System.out.println("!true = " + (!true)); // logical NOT

        System.out.println("---------------------");

        // 3. Assignment Operators
        int assign = 5;
        System.out.println("Assignment Operators:");
        assign += 3; // 8
        System.out.println("assign += 3 => " + assign);
        assign -= 2; // 6
        System.out.println("assign -= 2 => " + assign);
        assign *= 4; // 24
        System.out.println("assign *= 4 => " + assign);
        assign /= 6; // 4
        System.out.println("assign /= 6 => " + assign);
        assign %= 3; // 1
        System.out.println("assign %= 3 => " + assign);

        System.out.println("---------------------");

        // 4. Relational / Comparison Operators
        int p = 30, q = 40;
        System.out.println("Relational Operators:");
        System.out.println("p == q => " + (p == q));
        System.out.println("p != q => " + (p != q));
        System.out.println("p > q  => " + (p > q));
        System.out.println("p < q  => " + (p < q));
        System.out.println("p >= q => " + (p >= q));
        System.out.println("p <= q => " + (p <= q));

        System.out.println("---------------------");

        // 5. Logical Operators
        boolean x = true, y = false;
        System.out.println("Logical Operators:");
        System.out.println("x && y = " + (x && y));
        System.out.println("x || y = " + (x || y));
        System.out.println("!x = " + (!x));

        System.out.println("---------------------");

        // 6. Bitwise Operators
        int bit1 = 5;  // 0101
        int bit2 = 3;  // 0011
        System.out.println("Bitwise Operators:");
        System.out.println("bit1 & bit2 = " + (bit1 & bit2)); // 0001 -> 1
        System.out.println("bit1 | bit2 = " + (bit1 | bit2)); // 0111 -> 7
        System.out.println("bit1 ^ bit2 = " + (bit1 ^ bit2)); // 0110 -> 6
        System.out.println("~bit1 = " + (~bit1));             // -6
        System.out.println("bit1 << 1 = " + (bit1 << 1));     // 1010 -> 10
        System.out.println("bit1 >> 1 = " + (bit1 >> 1));     // 0010 -> 2
        System.out.println("bit1 >>> 1 = " + (bit1 >>> 1));   // 2 (unsigned shift)

        System.out.println("---------------------");

        // 7. Conditional / Ternary Operator
        int marks = 32;
        String res = (marks > 33) ? "Pass" : "Fail";
        System.out.println("Ternary Operator Result: " + res);

        System.out.println("---------------------");

        // 8. Type Casting Operator
        double d = 9.8;
        int i = (int) d; // narrowing
        System.out.println("Type Casting:");
        System.out.println("double d = " + d);
        System.out.println("int i = " + i);

        System.out.println("---------------------");

        // 9. instanceof Operator
        String str = "Hello";
        System.out.println("instanceof Operator:");
        System.out.println("str instanceof String: " + (str instanceof String));

        System.out.println("---------------------");

        // Extra: Complex Increment Example
        int ci = 6;
        int re = ci++ + ++ci + ++ci + ci++ + ++ci; // 6+8+9+9+11
        System.out.println("Complex Increment re = " + re); // 43

        int l = -6;
        int reo = l++ + --l + l-- + ++l; // -6 + (-6) + (-6) + (-6)
        System.out.println("Complex Increment/Decrement reo = " + reo); // -24
    }
}
