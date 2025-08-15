
public class J11_String {
    public static void main(String[] args) {
        // 1. Creating Strings
        String s1 = "Java"; // literal -> stored in SCP
        String s2 = new String("Java"); // heap + SCP reference

        // 2. == vs equals
        String s3 = "Java";
        System.out.println(s1 == s3);        // true (same SCP reference)
        System.out.println(s1.equals(s3));   // true (same content)
        System.out.println(s1 == s2);        // false (different objects)
        System.out.println(s1.equals(s2));   // true (content same)

        // 3. Immutability
        String name = "Rohit";
        name.concat("Kumar"); // doesn't change 'Rohit'
        System.out.println(name); // Rohit
        name = name.concat("Kumar"); // points to new object
        System.out.println(name); // RohitKumar

        // 4. StringBuffer (mutable, thread-safe)
        StringBuffer sb = new StringBuffer("Hello");
        sb.append(" World"); // modifies same object
        System.out.println(sb);

        // 5. StringBuilder (mutable, not thread-safe, faster)
        StringBuilder sb2 = new StringBuilder("Hi");
        sb2.append(" Java");
        System.out.println(sb2);
    }
}

/*
String:
-------
- Immutable class in java.lang
- Stored in SCP or Heap
- .equals() compares content, == compares reference
- Secure, cached, and thread-safe by design

StringBuffer:
-------------
- Mutable, thread-safe (synchronized)
- Slower than StringBuilder

StringBuilder:
--------------
- Mutable, not thread-safe
- Faster in single-threaded code
*/
