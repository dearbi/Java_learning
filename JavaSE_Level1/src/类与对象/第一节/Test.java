package 类与对象.第一节;

public class Test {
    public static void main(String[] args) {
        int a = 10;
        Dog dog1 = new Dog();
        dog1.name="安治昊";
        dog1.age=10;
        dog1.brand="金毛";
        System.out.println(dog1.name);
        dog1.eat();
        dog1.sleep();
        dog1.bark();

        MyDate myDate = new MyDate();
//        myDate.setDate(2025,5,25);
        myDate.printDate();
        System.out.println(myDate);

    }
}
