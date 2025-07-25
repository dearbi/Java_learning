package 栈;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    public void push(int val) {
        stack.push(val);
        if(minStack.empty()) {
            minStack.push(val);
        }else {
            int peekV = minStack.peek();
            if(val <= peekV) {
                minStack.push(val);
            }
        }
    }
    public void pop() {
        if(stack.empty()) {
            return;
        }
        int val = stack.pop();
        if(val == minStack.peek()) {
            minStack.pop();
        }
    }
    public int top() {
        if(stack.empty()) {
            return -1;
        }
        return stack.peek();
    }
    public int getMin() {
        return minStack.peek();
    }
}
