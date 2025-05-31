package IEDA调试_数组20250519;

import java.util.*;

public class IEDA调试_数组_20250519 {
    //3个汉诺塔
//    public static void hanoi(int n,char a,char b,char c){
//        if(n==1){
//            System.out.println("将"+a+"->"+c);
//        }else{
//            hanoi(n-1,a,c,b);
//            System.out.println("将"+a+"->"+c);
//            hanoi(n-1,b,a,c);
//        }
//    }
//    public static void main(String[] args) {
//        int a=10;
//        hanoi(a,'A','B','C');
//    }


    public static String myToString(int[] array) {
        String ret = "[";
        for (int x : array) {
            ret += x;
            if (x != array[array.length - 1])
                ret += ",";
        }
        ret += "]";

        return ret;
    }

    //数组逆置

    public static void reverase(int[] array) {
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            swap(array,i,j);
            i++;
            j--;
        }
    }
    public static void swap(int[] array, int i,int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};
        String ret = myToString(array);
        System.out.println(ret);

    }

    public static int[] fuc3() {
        int[] ret = {1, 2, 3, 4};
//        return ret;

        return ret = new int[]{1, 2, 3, 4};//Java中数组可以作为返回值传递
    }

    public static void test1(int[] array) {
        array = new int[]{10, 20, 30, 40, 50};
    }

    public static void test2(int[] array) {
        array[0] = 99;
    }

    public static void main2(String[] args) {
        //JVM内存布局
        int[] array = {1, 2, 3, 4, 5};
        test1(array);
        System.out.println(Arrays.toString(array));
        test2(array);
        System.out.println(Arrays.toString(array));
    }

    public static void main1(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
//        int array[] = {1, 2, 3, 4, 5};//Java这样写不好
        int[] array1 = new int[]{1, 2, 3, 4, 5};
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + " ");
        }
        System.out.println("\n------");
        for (int x : array1) {
            System.out.print(x + " ");
        }
        System.out.println("\n------");
        String ret = Arrays.toString(array);
        System.out.println(ret);
        int[] array2 = new int[5];//初始化，为0

        int[] array3;
        array3 = new int[]{1, 2, 3, 4, 5};

        boolean[] visited = new boolean[3];
        String[] strings = new String[3];

    }
}
