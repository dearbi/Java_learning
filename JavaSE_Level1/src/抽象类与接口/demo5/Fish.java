package 抽象类与接口.demo5;

public class Fish extends Animal implements ISwimable {
    public Fish(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("吃鱼粮...");
    }

    @Override
    public void swim() {
        System.out.println(this.name + "正在游");
    }
}
