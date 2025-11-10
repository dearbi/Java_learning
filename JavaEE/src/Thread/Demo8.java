package Thread;

public class Demo8 {
    public static void main(String[] args) {
        Thread t= new Thread(() -> {
            System.out.println("hello thread");
        });
        t.start();
        System.out.println("线程第一次启动");
        t.start();
        System.out.println("线程第二次启动");
    }
}
