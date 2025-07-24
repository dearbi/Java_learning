package 栈;

import java.util.Arrays;

public class MyStack {
    public int[] elem;
    public int usedSize;

    public MyStack(){
        this.elem=new int[10];
    }

    public void push(int val){
        if(isFull()){
            this.elem= Arrays.copyOf(elem,2*elem.length);
        }
        this.elem[usedSize++]=val;
    }

    public int pop(){
        if(isEmpty()){
            return -1;
        }
        return elem[--usedSize];
    }

    public int peek(){
        return elem[usedSize-1];
    }

    public boolean isEmpty() {
        return 0==elem.length;
    }
    public int size() {
        return usedSize;
    }
    public boolean isFull(){
        return usedSize==elem.length;
    }
}
