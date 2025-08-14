class J03_Casting{
    public static void main(String[] args){

        // IMPLICIT Casting----
        int a = 100;
        long b = a; //int -> long

        short s=12;
        int c=s; //short -->int

        System.out.println(b);
        System.out.println(s);
        System.out.println(c);
        System.out.println(a);

        // Explicit CAsting-----
        long sal= 78878729839237l;
        int x=(int)sal;// data loss

        System.out.println(x);
        System.out.println(sal);

        double d=77.89;
        int i=(int) d;// print only integer part remove decimal part
        System.out.println(i);

        char cg='a';
        int k=cg;// print asccii number
        System.out.println(k);
    }
}