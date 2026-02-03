package Thread;

class SingletonLazy{
    private static volatile SingletonLazy instance = new SingletonLazy();
    private static Object locker = new Object();
    public static SingletonLazy getInstance(){
        if(instance!=null){
            synchronized (locker){
                if(instance==null){
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }
}
public class Demo26 {
    public static void main(String[] args) {

    }
}
