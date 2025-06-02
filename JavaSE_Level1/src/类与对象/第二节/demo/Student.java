package 类与对象.第二节.demo;

public class Student {
    private String name;
    private int age;
    public static String classroom;//静态成员变量不依赖于对象，不需要实例化对象

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("构造方法被执行了");
    }

    {
        System.out.println("实例代码被执行了");
    }
    static {
        System.out.println("静态代码块被执行了");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
