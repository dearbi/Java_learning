package 多态.demo1;

public class Test {

    public static void fuc(Animal animal) {
        animal.eat();
    }
    //3.返回值传递
    public static Animal fuc2(int a){
        if(a==1){
            return new Dog("旺财",10);
        }
        else {
            return new Bird("啾啾",3);
        }
    }
    public static void main(String[] args) {
        Dog dog = new Dog("旺财", 10);
        dog.bark();
        dog.eat();
        //1.直接赋值
        Animal animal = new Dog("niu", 20);
        animal.eat();
        //2.参数传递
        Dog dog2 = new Dog("哈士奇", 12);
        Bird bird = new Bird("啾啾", 3);
        fuc(dog2);
        fuc(bird);
    }
}
