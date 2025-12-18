package Thread;

import java.util.Scanner;

public class Demo10 {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            //通过isInterrupted()方法来判断线程是否被中断
            while(!Thread.currentThread().isInterrupted()){
                System.out.println("hello thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);

                    //1.立即终止线程
//                    break;

                    //2.稍后处理

                    //3.不处理
                    continue;
                }
            }
            System.out.println("线程执行完毕");
        });
        t.start();

        System.out.println("输入任意字符，触发线程终止");
        Scanner sc = new Scanner(System.in);
        sc.next();

        //终止t线程
        t.interrupt();
    }
}
