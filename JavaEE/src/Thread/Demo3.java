package Thread;

public class Demo3 {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while(true){
                    System.out.println("hello thread");
                    try{
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        Thread t = new Thread(runnable);

        t.start();
        while(true){
            System.out.println("hello main");
            Thread.sleep(1000);
        }
    }
}
