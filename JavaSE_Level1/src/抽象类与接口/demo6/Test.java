package 抽象类与接口.demo6;

public class Test {
    public static void main(String[] args) {
        Person person1 = new Person("123");
        Person person2 = new Person("123");

        System.out.println(person1==person2);
        System.out.println(person1.equals(person2));

        System.out.println("=========");

        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());
    }
}
