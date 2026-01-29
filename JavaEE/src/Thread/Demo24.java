package Thread;

import java.util.Scanner;

public class Demo24 {
    public static void main(String[] args) {
        Object locker =new Object();

        Thread t1 = new Thread(()->{
            synchronized (locker) {
            System.out.println("t1 wait 之前");
            try {
                locker.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("t1 wait 之后");
            }
        });
            Thread t2 = new Thread(()->{
                synchronized (locker) {
                System.out.println("t2 wait 之前");
                try {
                    locker.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("t2 wait 之后");
                }
            });
            Thread t3 = new Thread(()->{
                synchronized (locker) {
                System.out.println("t3 wait 之前");
                try {
                    locker.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("t3 wait 之后");
                }
            });

        Thread t4 =new Thread(()->{
            Scanner scanner =new Scanner(System.in);
            System.out.println("请输入任意内容，唤醒线程");
            scanner.nextLine();
            synchronized (locker) {
                //当有多个线程等待时，notify是随机唤醒一个线程
                locker.notify();
            }
        });


        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
