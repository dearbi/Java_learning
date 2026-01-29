package Thread;

import java.util.Scanner;

public class Demo23 {
    public static void main(String[] args) {
        Object object=new Object();
        Thread t1=new Thread(()->{
            synchronized (object){
               System.out.println("t1 wait之前");
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
               System.out.println("t1 wait之后");
            }
        });

        Thread t2=new Thread(()->{
           synchronized (object){
               System.out.println("请输入任意内容启动t1线程");
               Scanner scanner = new Scanner(System.in);
               scanner.next();
               synchronized (object){
                   object.notify();
               }
           }
        });
        t1.start();
        t2.start();
    }
}
