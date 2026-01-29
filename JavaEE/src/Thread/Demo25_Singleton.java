package Thread;

//这个类就要设计成单例模式，只能有一个实例
class Singleton{
    //借助static关键字，确保只有一个实例
     static Singleton instance = new Singleton();

    public static Singleton getInstance(){
        return instance;
    }
    //构造方法私有化，防止外部实例化
    private Singleton(){
    }
}

public class Demo25_Singleton {
    public static void main(String[] args) {
//      Singleton singleton = new Singleton();//编译错误
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1==s2);
    }
}
