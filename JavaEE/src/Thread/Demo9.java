package Thread;

import java.util.Scanner;

public class Demo9 {
    private static boolean isRunning = true;

    public static void main(String[] args) {
        Thread t2 = new Thread(() -> {
            //通过while来模拟执行很长的情况
            while(isRunning){
                System.out.println("hello thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
                System.out.println("线程执行完毕");
        });
        t2.start();

        //在main方法中，让用户通过进行输入，触发t线程的终止
        Scanner sc = new Scanner(System.in);
        System.out.println("输入任意字符，触发线程终止");
        sc.next();//使用这个方法，main就会阻塞，等待用户输入
        isRunning = false;
    }
}
