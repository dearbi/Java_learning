// Animal.java
class Animal {
    String name;
    int age;

    public void eat() {
        System.out.println(name + "正在吃饭");
    }

    public void sleep() {
        System.out.println(name + "正在睡觉");
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

// Dog.java
class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }

    void bark() {
        System.out.println(name + "汪汪汪~~~");
    }
}

// Cat.Java
class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    void mew() {
        System.out.println(name + "喵喵喵~~~");
    }
}

// TestExtend.java
public class Test {
    public static void main(String[] args) {
        Dog dog = new Dog("niubi", 1);
    // dog类中并没有定义任何成员变量，name和age属性肯定是从父类Animal中继承下来的
        System.out.println(dog.name);
        System.out.println(dog.age);
    //dog访问的eat()和sleep()方法也是从Animal中继承下来的
        dog.eat();
        dog.sleep();
        dog.bark();
    }
}