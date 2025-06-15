package 多态.demo1;

public class Bird extends Animal{

    public Bird(String name, int age) {
        super(name, age);
    }

    void eat(){
        System.out.println(name+"正在吃鸟粮");
    }
}
