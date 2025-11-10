package Thread;

class MyThread extends Thread{
    @Override
    public void run() {
        while (true){
            System.out.println("hello thread");
            try {
                    Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class Demo1{
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.run();

        while(true){
            System.out.println("hello world");
            Thread.sleep(100);
        }
    }
}