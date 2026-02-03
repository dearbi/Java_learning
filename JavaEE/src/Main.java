public class Main {
    // 此处定义一个 int 类型的变量
    private static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            // 对 count 变量进行自增 5w 次
            for (int i = 0; i < 50000; i++) {
                count++;
            }
        });
        Thread t2 = new Thread(() -> {
            // 对 count 变量进行自增 5w 次
            for (int i = 0; i < 50000; i++) {
                count++;
            }
        });
        t1.start();
        t2.start();
        // 如果没有这俩 join, 肯定不行的. 线程还没自增完, 就开始打印了. 很可能打印出来的count 就是个0

        t1.join();
        t2.join();
        // 预期结果应该是 10w
        System.out.println("count: " + count);
    }
}
