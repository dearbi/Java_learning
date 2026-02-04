package Thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class MyThreadPoolExecutor {
    private BlockingQueue<Runnable> queue=new LinkedBlockingQueue<Runnable>();
    public MyThreadPoolExecutor(int nThread) {
        //需要根据当前指定的参数，创建出若干线程
        //创建出的线程要能执行任务
        for (int i=0;i<nThread;i++){
            Thread t=new Thread(()->{
               try {
                   while(true){
                       Runnable runnable=queue.take();
                       runnable.run();
                   }
               }catch (Exception e){
                   e.printStackTrace();
               }
            });
            t.start();
        }
    }
    public void submit(Runnable runnable) throws InterruptedException {
        queue.put(runnable);
    }
}

public class Demo32_线性池 {
    public static void main(String[] args) throws InterruptedException {
        MyThreadPoolExecutor executor=new MyThreadPoolExecutor(1000);
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            executor.submit(()->{
                System.out.println("线程"+Thread.currentThread().getName()+"执行"+"是第"+ finalI +"个");
            });
        }
        Thread.sleep(1000);
    }
}
