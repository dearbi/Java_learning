package Thread;

public class Demo14 {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Thread.sleep(1000);
        long endTime = System.currentTimeMillis();
        System.out.println("线程休眠了" + (endTime - startTime) + "毫秒");
    }
}
