package 多态.demo1;

public class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }
    void bark(){
        System.out.println(name+"正在汪汪叫");
    }
    void eat(){
        System.out.println(name+"正在吃狗粮");
    }
}
