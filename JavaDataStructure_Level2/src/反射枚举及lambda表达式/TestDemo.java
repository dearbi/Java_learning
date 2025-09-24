package 反射枚举及lambda表达式;

public class TestDemo {
    public static void main(String[] args) {
        /*
        1.通过getClass获取Class对象
        */
        Student s1 = new Student();
        Class c1 = s1.getClass();
        /*
        2.直接通过 类名.class 的方式得到,该方法最为安全可靠，程序性能更高
        这说明任何一个类都有一个隐含的静态成员变量 class
        */
        Class c2 = Student.class;
        /*
        3、通过 Class 对象的 forName() 静态方法来获取，用的最多，
        但可能抛出 ClassNotFoundException 异常
        */
        Class c3 = null;
        try {
        //注意这里是类的全路径，如果有包需要加包的路径
            c3 = Class.forName("反射枚举及lambda表达式.Student");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //一个类在 JVM 中只会有一个 Class 实例,即我们对上面获取的
        //c1,c2,c3进行 equals 比较，发现都是true
        System.out.println(c1.equals(c2));
        System.out.println(c1.equals(c3));
        System.out.println(c2.equals(c3));
    }
}

