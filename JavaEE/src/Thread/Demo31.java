package Thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo31 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            service.submit(()->{
                System.out.println("线程"+Thread.currentThread().getName()+"执行"+"是第"+ finalI +"个");
            });
        }
        Thread.sleep(1000);

    }
}
