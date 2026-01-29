package Thread;

public class Demo22_wait {
    public static void main(String[] args) throws InterruptedException {
        Object object =new Object();
        synchronized (object) {
            System.out.println("wait之前");
            object.wait();
            System.out.println("wait之后");
        }
    }
}
