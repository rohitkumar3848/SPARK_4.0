package pkg1; // 👈 Ye add karo

public class SamePackageTest {
    public static void main(String[] args) {
        AcessDemo1 obj = new AcessDemo1();
        System.out.println(obj.pubVar);      // ✅
        System.out.println(obj.protVar);     // ✅
        System.out.println(obj.defVar);      // ✅
        // System.out.println(obj.privVar);  // ❌

        obj.publicMethod();    // ✅
        obj.protectedMethod(); // ✅
        obj.defaultMethod();   // ✅
        // obj.privateMethod(); // ❌
    }
}


