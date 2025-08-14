
// ======= FILE: NonSubclassInDiffPackage.java =======
package pkg2;

import pkg1.AcessDemo1;

public class NonSubclassInDiffPackage {
    public static void main(String[] args) {
        AcessDemo1 obj = new AcessDemo1();
        System.out.println(obj.pubVar);      // ✅
        // System.out.println(obj.protVar);  // ❌
        // System.out.println(obj.defVar);   // ❌
        // System.out.println(obj.privVar);  // ❌

        obj.publicMethod();    // ✅
        // obj.protectedMethod(); // ❌
        // obj.defaultMethod();   // ❌
        // obj.privateMethod();   // ❌
    }
}