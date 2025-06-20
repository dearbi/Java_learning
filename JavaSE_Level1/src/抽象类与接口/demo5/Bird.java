package 抽象类与接口.demo5;

public class Bird extends Animal implements IRunable,IFlyable{
    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println(this.name+"吃鸟粮...");
    }

    @Override
    public void fly() {
        System.out.println(this.name+"正在用翅膀飞翔...");
    }

    @Override
    public void run() {
        System.out.println(this.name+"正在用两条鸟腿跳...");
    }
}
