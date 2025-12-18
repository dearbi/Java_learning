package Thread;

public class Demo12 {
    private static int result = 0;
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();

        //在main线程中计算1+2+3+...+100的和
        Thread t1 = new Thread(()->{
            try {
                mainThread.join();
                System.out.println("子线程执行完毕"+result);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();

        int sum = 0;
        for(int i=1;i<=100;i++){
            sum += i;
        }
        result = sum;

    }
}
