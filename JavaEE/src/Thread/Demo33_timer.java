package Thread;

import java.util.Timer;
import java.util.TimerTask;

public class Demo33_timer {

    public static void main(String[] args) {
        Timer timer = new Timer();
        //添加任务
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        },1000);
        System.out.println("hello main");
    }

}
