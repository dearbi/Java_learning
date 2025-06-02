package 继承.demo1;

public class Animal {
    public String name;
    public int age;

    static {
        System.out.println("父类的静态代码块---1");
    }

    {
        System.out.println("父类的实例代码块---2");
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("执行了父类的构造方法---3");
    }

    public void sleep() {
        System.out.println(name + "正在睡觉");
    }

    public void eat() {
        System.out.println(name + "正在吃饭");
    }
}
