package 继承.demo2;

public class Derived extends Base {
    public int a = 2;
    public int b;
    public int c;

    public void test() {
        System.out.println(this.a);
        System.out.println(super.a);
        System.out.println(b);
        System.out.println(c);

        super.method();
        method();
    }
    public void method() {
        System.out.println("Derived :: method()"+a);
    }
    public void methodB() {
        System.out.println("Derived :: methodB()");
    }
}
