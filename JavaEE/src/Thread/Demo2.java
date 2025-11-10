package Thread;

public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        //子类的属性和方法
        Thread t= new Thread(){
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

        t.start();
        while(true){
            System.out.println("hello main");
            Thread.sleep(1000);
        }
    }
}
