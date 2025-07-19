package 泛型;

class MyArray<T> {
    public Object[] array = new Object[10];

    public void setVal(int pos, T val) {
        this.array[pos] = val;
    }

    public T getPos(int pos) {
        return (T)this.array[pos];
    }
}


public class Test {
    public static void main1(String[] args) {
        int a=10;;
        Integer i=a;
        System.out.println(i);

        Integer i2=Integer.valueOf(a);
        System.out.println(i2);

    }

    public static void main(String[] args) {
        MyArray<Integer> myArray = new MyArray<Integer>();
        myArray.setVal(0,10);
        myArray.setVal(1,23);
        Integer ret=myArray.getPos(1);
        System.out.println(ret);

        MyArray<String> myArray2 = new MyArray<String>();
        myArray2.setVal(0,"hello");
        myArray2.setVal(1,"world");

        String s=(String)myArray2.getPos(1);
        System.out.println(s);
    }
}

