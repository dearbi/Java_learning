package Thread;

public class Demo11 {
    private static int result = 0;
    public static void main(String[] args) throws InterruptedException {
        //让这个线程从1+2+3+...+100的和
        //主线程中打印结果
        //创建一个线程
        Thread t = new Thread(()->{
            int sum = 0;
            for(int i=1;i<=100;i++){
                sum += i;
            }
            result = sum;
            System.out.println("子线程执行完毕，结果为："+result);
        });

        t.start();
//
//        Thread.sleep(1000);

        t.join();

        System.out.println(result);
    }
}
