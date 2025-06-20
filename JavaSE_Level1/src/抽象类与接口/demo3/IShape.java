package 抽象类与接口.demo3;

public interface IShape {
    //接口中的成员变量默认是public static final修饰的-->常量
    public static final int a=10;
    int b=1000;
    //接口中的抽象方法默认是public abstract
    void draw();

}
