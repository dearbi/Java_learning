package Thread;
/**
 * 演示线程安全问题
 */
public class Demo16_线程安全问题 {
    private  static int count = 0,count2 = 0;
    public static void main(String[] args) throws InterruptedException {
        //创建两个线程，针对同一个变量进行循环自增

        //定义一个锁对象，可以是任意的对象
        Object locker = new Object();

        Thread t1 = new Thread(()->{
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            for(int i=0;i<50000;i++){
                synchronized (locker){
                    count++;
                }
            }
        });

        Thread t2 = new Thread(()->{
            for(int i=0;i<50000;i++){
                synchronized (locker){
                    count++;
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("count = " + (count+count2));

    }
}
