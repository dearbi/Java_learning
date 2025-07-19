package List;

import java.util.Arrays;

public class MyArrayList implements IList {
    public int[] elem;
    public int usedSize;

    public static final int DEAFULT_CAPACITY = 10;

    public MyArrayList() {
        elem = new int[DEAFULT_CAPACITY];
    }

    public MyArrayList(int initialCapacity) {
        elem = new int[initialCapacity];
    }

    //把数据存放到数据表当中（最后一个位置）
    @Override
    public void add(int data) {
        if (ifFull()) {
            //扩容-》2倍扩容
            grow();
        }
        elem[usedSize] = data;
        usedSize++;
    }

    private void grow() {
        elem = Arrays.copyOf(elem, 2 * elem.length);
    }

    boolean ifFull() {
        return usedSize == elem.length;
    }

    @Override
    public void add(int pos, int data) {
        checkPos(pos);
        if (ifFull()) {
            //扩容-》2倍扩容
            grow();
        }
        //1.移动元素
        for (int i = usedSize - 1; i >= pos; i--) {
            elem[i + 1] = elem[i];
        }
        elem[pos] = data;
        usedSize++;
    }

    private void checkPos(int pos) {
        if (pos < 0 || pos > usedSize) {
            throw new RuntimeException("pos位置不合法:" + pos);
        }
    }

    private boolean isEmpty(){
        return usedSize == 0;
    }

    @Override
    public boolean contains(int toFind) {
        for (int i = 0; i < usedSize; i++) {
            if (elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(int toFind) {
        for (int i = 0; i < usedSize; i++) {
            if (elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int get(int pos) {
        if(isEmpty()){
            throw new ListEmployeeException("获取元素为空");
        }
        checkPos(pos);
        return elem[pos];
    }

    @Override
    public void set(int pos, int value) {
        checkPos(pos);
        elem[pos] = value;
    }

    @Override
    public void remove(int toRemove) {
        int index = indexOf(toRemove);
        if (index == -1) {
            throw new ListEmployeeException("没有这个元素");
        }
        for (int i = index; i < usedSize - 1; i++) {
            elem[i] = elem[i + 1];
            usedSize--;
        }
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {
        usedSize = 0;
    }

    @Override
    public void display() {
        for (int i = 0; i < usedSize; i++) {
            System.out.print(elem[i]+" ");
        }
        System.out.println();
    }


}

