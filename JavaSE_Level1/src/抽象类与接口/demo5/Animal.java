package 抽象类与接口.demo5;

public abstract class Animal {
    public String name;
    public int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public abstract void eat();

}
