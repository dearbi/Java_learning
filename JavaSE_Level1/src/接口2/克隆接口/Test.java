package 接口2.克隆接口;

public class Test {
    public static void main(String[] args) throws Exception {
        Person person1 = new Person(12);
        Person person2 = (Person) person1.clone();
        System.out.println(person1.m.money);
        System.out.println(person2.m.money);
        System.out.println("===========");

        person2.m.money=99.99;

        System.out.println(person1.m.money);
        System.out.println(person2.m.money);
        System.out.println("===========");


    }
}
