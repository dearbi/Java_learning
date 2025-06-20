package 抽象类与接口.demo2;

public class Rect extends Shape{
    @Override
    public void draw() {
        System.out.println("画一个矩形...");
    }
}

abstract class A extends Shape {
    abstract void test();
}
class C extends A{

    @Override
    void test() {

    }

    @Override
    public void draw() {

    }
}
