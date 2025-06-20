package 抽象类与接口.demo5;

public class Test {

    public static void eat(Animal animal) {
        animal.eat();
    }

    public static void running(IRunable runable){
        runable.run();
    }
    public static void flying(IFlyable flyable){
        flyable.fly();
    }
    public static void swimming(ISwimable swimable){
        swimable.swim();
    }
    public static void main(String[] args) {
        Dog dog = new Dog("旺财",10);
        Bird bird= new Bird("啾啾",1);
        Fish fish = new Fish("小鱼儿",1);

        eat(dog);
        eat(bird);
        System.out.println("============");

        running(dog);
        running(bird);
        System.out.println("============");

        flying(bird);
        System.out.println("============");

        swimming(fish);
        swimming(dog);
        System.out.println("============");

    }
}
