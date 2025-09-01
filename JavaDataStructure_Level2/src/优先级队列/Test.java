package 优先级队列;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Test {
    static void TestPriorityQueue() {
        PriorityQueue<Integer> q1 = new PriorityQueue<>();
        //直接在优先队列中加入元素
        q1.offer(1);
        q1.offer(6);
        q1.offer(2);
        //可以弹出元素到集合中
        ArrayList<Integer> list = new ArrayList<>();
        while (!q1.isEmpty()) {
            list.add(q1.poll());
        }
        System.out.println(list);

        //可以在优先队列中加入集合
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(1);
        list1.add(2);

        PriorityQueue<Integer> q2 = new PriorityQueue<>(list1);
        System.out.println(q2.size());
        System.out.println(q2.peek());//不弹出打印
        System.out.println(q2.poll());//弹出打印
        System.out.println(q2.size());

    }

    public static void main(String[] args) {
        TestPriorityQueue();
    }

}