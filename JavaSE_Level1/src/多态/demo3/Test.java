package 多态.demo3;
//有坑的代码
class B {
    public B() {
        func();
    }

    public void func() {
        System.out.println("B.fuc()...");
    }

}

class D extends B {
    private int num = 1;


    //默认有:
/*    public D(){
        super();
    }*/

    @Override
    public void func() {
        System.out.println("D.func()" + num);
    }
}

public class Test {
    public static void main(String[] args) {
        D d = new D();
    }
}

