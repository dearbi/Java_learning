package Thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Demo28_生产者消费者 {
    public static void main(String[] args) {
        //编写一个生产者消费者模型
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1000);

        //生产者和消费者都是线程
        Thread prouder = new Thread(()->{
            int count =0;
            try {
                while(true){
                    count++;
                    queue.put(count+" ");
                    System.out.println("生产元素： "+count);

                    //生产一个元素，消费者就可以消费一个元素
//                    Thread.sleep(1000);
                }
           } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumer = new Thread(()->{
            try {
                while(true){
                    System.out.println("消费元素： "+queue.take());

                    //消费一个元素，生产者就可以生产一个元素
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        prouder.start();
        consumer.start();
    }
}
