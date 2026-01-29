package Thread;

public class Demo18 {
    public static void main(String[] args) {
        Object locker = new Object();

        Thread t1=new Thread(()->{
            synchronized (locker) {
                synchronized (locker) {
                    System.out.println("t1");
                }
            }
        });
        t1.start();
    }
}

