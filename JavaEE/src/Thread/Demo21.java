package Thread;

import java.util.Scanner;

public class Demo21 {
    private static volatile boolean flag=true;

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            while(flag){
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
            }
            System.out.println("t1线程结束");
        });

        Thread t2 = new Thread(()->{
            System.out.println("请输入任意内容，终止t1线程");
            Scanner scanner = new Scanner(System.in);
            scanner.next();
            //通过修改flag让t1线程结束
            flag=false;
            System.out.println("flag = " + flag);
        });
        t1.start();
        t2.start();
    }
}
