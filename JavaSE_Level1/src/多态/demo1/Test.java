package 多态.demo1;

public class Test {

    public static void fuc(Animal animal) {
        animal.eat();
    }

    public static void main(String[] args) {
        Dog dog = new Dog("旺财", 10);
        dog.bark();
        dog.eat();

        Animal animal = new Dog("niu", 20);
        animal.eat();

        Dog dog2 = new Dog("哈士奇", 12);
        Bird bird = new Bird("啾啾", 3);
        fuc(dog2);
        fuc(bird);
    }
}
