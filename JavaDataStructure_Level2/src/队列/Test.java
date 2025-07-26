package 队列;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
        //测试用栈来实现队列，用MyStack
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
    public static void main2(String[] args) {
        Deque<Integer> queue1 = new LinkedList<>();
        Deque<Integer> queue2 = new ArrayDeque<>();
        Deque<Integer> stack = new LinkedList<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
    }
    public static void main1(String[] args) {
        Queue<Integer> queue =new LinkedList<>();
        queue.offer(12);
        queue.offer(23);
        queue.offer(34);
        queue.offer(45);
        System.out.println(queue.poll());
        System.out.println(queue.peek());
    }
}
