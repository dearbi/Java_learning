package 抽象类与接口.demo5;

public class Dog extends Animal implements IRunable,ISwimable {
    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println(this.name + "吃狗粮...");
    }

    @Override
    public void run() {
        System.out.println(this.name+"正在用四条狗腿跑步");
    }

    @Override
    public void swim() {
        System.out.println(this.name+"正在用四条狗腿狗刨");
    }
}
