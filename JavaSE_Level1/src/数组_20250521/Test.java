package 数组_20250521;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] array=new int[10];
        Arrays.fill(array, 0,4,8);
        System.out.println(Arrays.toString(array));
    }
    public static void main2(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int[] copy = Arrays.copyOf(array, array.length);
        System.out.println(Arrays.toString(copy));//[1, 2, 3, 4, 5]
        copy=Arrays.copyOfRange(array, 1, 3);
        System.out.println(Arrays.toString(copy));//[2, 3]

        //排序
        int []array2 = new int[]{1, 2, 3, 4, 5};
        Arrays.sort(array2);
        Arrays.sort(array2,2,5);

        //直接调用二分查找
        int index = Arrays.binarySearch(array2, 3);
        System.out.println(index);
    }

    //数组拷贝
    public static void main1(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        for (int x : copy) {
            System.out.println(x);
        }

        //下面这个不是拷贝，都是指向一个对象
        int[] array2 = array;
        for (int x : array2) {
            System.out.println(x);
        }
    }
}
