package 栈;

import java.util.Stack;

public class Test {
    public boolean IsPopOrder (int[] pushV, int[] popV) {
        // write code here
        Stack<Integer> stack=new Stack<>();
        int j=0;
        int i=0;
        for(;i<pushV.length;i++){
            stack.push(pushV[i]);
            while(!stack.isEmpty()&&j<popV.length&&stack.peek()==popV[j]){
                stack.pop();
                j++;
            }
        }

        return stack.empty();
    }
    public static void main(String[] args) {
        MyStack myStack =new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
        System.out.println(myStack.isEmpty());
        System.out.println(myStack.size());
    }
    public static void main1(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
