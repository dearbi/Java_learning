package Thread;

public class Demo15 {
    public static void main(String[] args) throws InterruptedException {
        Thread mainThread = Thread.currentThread();
        Thread t = new Thread(()->{
//            for(int i=0;i<3;i++) {
//                System.out.println("hello thread");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
            try {
                mainThread.join(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println(t.getState());
        t.start();
        Thread.sleep(900);
        System.out.println(t.getState());
        t.join();
        System.out.println(t.getState());
    }
}
