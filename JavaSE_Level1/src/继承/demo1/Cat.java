package 继承.demo1;

public class Cat extends Animal {
    static {
        System.out.println("执行了Cat的静态代码块---4");
    }

    {
        System.out.println("执行了Cat的实例代码块---5");
    }

    public Cat(String name, int age) {
        super(name, age);
        System.out.println("执行了子类的构造方法---6");
    }


    public void miao() {
        System.out.println(name + "正在猫叫");
    }
}
