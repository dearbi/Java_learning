package Thread;

class MyBlockingQueue{
    private String[] data= null;
    private int head=0;
    private int tail=0;
    private int size=0;

    private final Object locker=new Object();

    public MyBlockingQueue(int capacity){
        data = new String[capacity];
    }
    public void put(String elem) throws InterruptedException {
        synchronized (locker){
            while(size==data.length){
                //队列满了
                locker.wait();
            }
            data[tail]=elem;
            tail++;
            if(tail>=data.length){
                tail=0;
            }
            size++;
            locker.notify();
        }
    }

    public String take() throws InterruptedException {
        synchronized (locker){
            while(size==0){
                locker.wait();
            }
            String ret=data[head];
            head++;
            if(head>= data.length){

                head=0;
            }
            size--;
            locker.notify();
            return ret;
        }
    }
}

public class Demo29_手搓阻塞队列 {
    public static void main(String[] args) {

        MyBlockingQueue queue = new MyBlockingQueue(10);
        Thread consumer = new Thread(()->{
            try {
                int n=1;
                while(true){
                    queue.put(n+"");
                    System.out.println("生产元素 :"+n);
                    n++;

//                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread producer = new Thread(()->{
            try {
                while(true){
                    String elem = queue.take();
                    System.out.println("消费元素 :"+elem);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        consumer.start();
        producer.start();
    }
}
