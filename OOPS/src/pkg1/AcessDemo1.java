

// ======= FILE: AccessDemo1.java =======
package pkg1;

public class AcessDemo1 {
    public String pubVar = "Public Variable";
    protected String protVar = "Protected Variable";
    String defVar = "Default Variable";
    private String privVar = "Private Variable";

    public void publicMethod() {
        System.out.println("Public Method");
    }

    protected void protectedMethod() {
        System.out.println("Protected Method");
    }

    void defaultMethod() {
        System.out.println("Default Method");
    }

    private void privateMethod() {
        System.out.println("Private Method");
    }

    public void showAllFromSameClass() {
        System.out.println(pubVar);
        System.out.println(protVar);
        System.out.println(defVar);
        System.out.println(privVar);
        publicMethod();
        protectedMethod();
        defaultMethod();
        privateMethod();
    }
}