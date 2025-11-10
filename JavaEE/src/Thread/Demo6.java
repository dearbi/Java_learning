package Thread;

public class Demo6 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread((Runnable) () -> {
            while(true){
                System.out.println("hello thread");
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "thread t");
        // 守护线程：当主线程结束时，守护线程也会结束、
        //没有setDaemon(true)，t1会一直运行（默认是前台进程）
        // 而设置了setDaemon(true)，t1会在主线程结束后结束（后台进程）
        t1.setDaemon(true);
        t1.start();
        Thread.sleep(4000);
    }
}
