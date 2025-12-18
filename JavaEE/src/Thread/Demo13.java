package Thread;

public class Demo13 {
    public static void main(String[] args) {
        Thread t= new Thread(){
            @Override
            public void run() {
                System.out.println(this.getName());
                System.out.println(Thread.currentThread().getName());
            }
        };
        t.start();

        Thread t2= new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        t2.start();


        Thread t3= new Thread(()->{
//            System.out.println(this.getName());
            System.out.println(Thread.currentThread().getName());
        });
        t3.start();

    }
}
