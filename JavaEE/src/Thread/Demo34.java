package Thread;

import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

// 表示定时器中要执行的一个任务
class MyTimerTask implements Comparable<MyTimerTask> {
    private Runnable runnable;
    // 存毫秒级别的时间戳
    private long time;

    public MyTimerTask(Runnable runnable, long delay) {
        this.runnable = runnable;
        this.time = System.currentTimeMillis() + delay;
    }

    public long getTime() {
        return time;
    }

    public void run() {
        runnable.run();
    }

    @Override
    public int compareTo(MyTimerTask o) {
        // 时间小的在队首 (小堆)
        // this - o 还是 o - this?
        // 不要记!!!
        // 试试就知道了!!
        return (int) (this.time - o.time);
    }
}

class MyTimer {
    private PriorityQueue<MyTimerTask> queue = new PriorityQueue<>();
    private Object locker = new Object();
    // private PriorityBlockingQueue

    public MyTimer() {
        // 创建专门的线程, 负责执行队列中的任务.
        Thread t = new Thread(() -> {
            // 从队列中取队首元素
            // 判定队首元素是否时间到了
            // 时间没到, 先不执行
            // 时间到了, 执行任务, 并且把元素出队列.

            try {
                while (true) {
                    synchronized (locker) {
                        while (queue.isEmpty()) {
                            locker.wait();
                        }
                        MyTimerTask task = queue.peek();
                        long currentTime = System.currentTimeMillis();
                        if (currentTime >= task.getTime()) {
                            // 时间到了, 可以执行任务了!
                            task.run();
                            queue.poll();
                        } else {
                            // 需要带有超时时间的等待
                            locker.wait(task.getTime() - currentTime);
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
    }

    public void schedule(Runnable task, long delay) {
        // offer 这个方法名字就很吉利~~
        synchronized (locker) {
            queue.offer(new MyTimerTask(task, delay));
            locker.notify();
        }
    }
}

public class Demo34 {
    public static void main(String[] args) {
        MyTimer myTimer = new MyTimer();
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 1");
            }
        }, 4000);
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 2");
            }
        }, 3000);
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 3");
            }
        }, 2000);
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 4");
            }
        }, 1000);
        System.out.println("hello main");
    }
}
