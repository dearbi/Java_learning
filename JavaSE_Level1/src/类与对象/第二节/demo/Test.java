package 类与对象.第二节.demo;

public class Test {
    public static void main(String[] args) {
        Student student = new Student("张三", 19);
    }

    public static void main2(String[] args) {
        Student student1 = new Student("张三", 10);

        /*student1.classroom="118";*/
        Student.classroom = "118";
        Student student2 = new Student("李四", 12);
        Student.classroom = "118";
    }

    public static void main1(String[] args) {
        Student student = new Student("张三", 18);
//        student.name="lisi";
//        System.out.println(student.name);
        student.setName("lisi");
        System.out.println(student.getName());

    }
}
