package 单例模式;

public class Singleton {
    //饿汉式
    private static Singleton instance = new Singleton();
    private Singleton(){

    }
    public static Singleton getInstance(){
        return instance;
    }
}
