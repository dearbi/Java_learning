package 队列;

public class MyCircularQueue {
    public int[] elem;
    public int front;//头
    public int rear;//尾
    public int size;//记录有效数据的个数
    public int capacity;//记录数组的容量

    public MyCircularQueue(int k) {
        this.elem = new int[k];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
        this.capacity = k;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        this.elem[this.rear] = value;
        this.rear = (this.rear + 1) % this.capacity;
        this.size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        this.front = (this.front + 1) % this.capacity;
        this.size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return this.elem[this.front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        int index = (this.rear == 0) ? this.capacity - 1 : this.rear - 1;
        return this.elem[index];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.capacity;
    }
}