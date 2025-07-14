package 单例模式;

public class Singleton2 {
    //懒汉式
    private static Singleton2 instance;
    private Singleton2(){

    }

    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
