package Thread;

public class Demo7 {
    public static void main(String[] args) throws InterruptedException {
        Thread t= new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("hello thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        //获取t的存活状态
        System.out.println(t.isAlive());

        t.start();

        Thread.sleep(1000);
        System.out.println(t.isAlive());//运行中

        // 等待t线程执行完毕
        Thread.sleep(4000);
        System.out.println(t.isAlive());
    }
}
