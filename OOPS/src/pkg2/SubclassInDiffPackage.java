
// ======= FILE: SubclassInDiffPackage.java =======
package pkg2;

import pkg1.AcessDemo1;

public class SubclassInDiffPackage extends AcessDemo1 {
    public static void main(String[] args) {
        SubclassInDiffPackage obj = new SubclassInDiffPackage();
        System.out.println(obj.pubVar);      // ✅
        System.out.println(obj.protVar);     // ✅ (protected accessible via inheritance)
        // System.out.println(obj.defVar);   // ❌
        // System.out.println(obj.privVar);  // ❌

        obj.publicMethod();    // ✅
        obj.protectedMethod(); // ✅
        // obj.defaultMethod(); // ❌
        // obj.privateMethod(); // ❌
    }
}

