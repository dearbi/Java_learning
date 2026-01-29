package Thread;

public class Demo19 {
    public static void main(String[] args) {
        Object lockerA = new Object();
        Object lockerB = new Object();

        Thread t1=new Thread(()->{
            synchronized (lockerA) {
                try {
                    // 加sleep是为了确保对方线程已经把lockerB锁上
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (lockerB) {
                    System.out.println("t1");
                }
            }
        });

        Thread t2=new Thread(()->{
            synchronized (lockerA) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (lockerB) {
                    System.out.println("t2");
                }
            }

        });
        t1.start();
        t2.start();
    }

}





