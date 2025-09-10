import java.util.Arrays;

/** 
 * @Author 12629
 * @Description：
 */
public class Test {


    public static String myToString(int[] array) {
        String ret = "[";

        //1, 2, 4,
        for (int i = 0; i < array.length; i++) {
            ret += array[i];
            if(i != array.length-1) {
                ret += ",";
            }
        }

        ret += "]";

        return ret;
    }

    public static void reverse(int[] array) {
        int i = 0;
        int j = array.length-1;
        while (i < j) {
            swap(array,i,j);
            i++;
            j--;
        }
    }

    public static void swap(int[] array,int i,int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        reverse(array);
        //[1, 2, 3, 4, 5]
        String ret = myToString(array);
        System.out.println(ret);

    }

    public static int[] func3() {
        /*int[] ret = {1,2,3,4};
        return ret;*/

        return new int[]{1,2,3,4};
    }

    public static void main9(String[] args) {
        int[] r = func3();
        print(r);
    }

    public static void func2(int x) {
        x *= 2;
        System.out.println("x = "+x);
    }

    public static void test1(int[] array) {
        array = new int[]{10,20,30,40,50};
    }

    public static void test2(int[] array) {
        array[0] = 99;
    }

    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public static void main8(String[] args) {
        int[] array = {1,2,3,4,5};
        //test1(array);
        print(array);
        //1:  xxxxxx
        //2:  xxxxxx

    }


    public static void main7(String[] args) {
        int a = 0;
        System.out.println(a);

        int[] array1 = null;
        System.out.println(array1[0]);
    }


    public static void main6(String[] args) {
        int[] array1 = new int[3];
        array1[0] = 10;
        array1[1] = 20;
        array1[2] = 30;

        int[] array2 = new int[]{1,2,3,4,5};
        array2[0] = 100;
        array2[1] = 200;


        array1 = array2;
        array1[2] = 300;
        array1[3] = 400;
        array2[4] = 500;

        for (int i = 0; i < array2.length; i++) {
            System.out.println(array2[i]);
        }

    }

    public static void main5(String[] args) {
        int[] array = {1,2,3,4,5};
        //0  1 2 3 4   数组名+点号+length获取数组的长度
        for (int i = 0; i < array.length; i++) {
            //if(i == 2) .....
            System.out.print(array[i]+" ");
        }
        System.out.println();
        System.out.println("=================");
        //for-each  增强for循环
        for(int x : array) {
            System.out.print(x+" ");
        }
        System.out.println();
        System.out.println("=================");
        //把数组以字符串的形式进行输出 [1,2,3,4,5]
        String ret = Arrays.toString(array);
        System.out.println(ret);



       /* System.out.println(array[0]);
        System.out.println(array[4]);

        array[0] = 100;
        System.out.println(array[0]);*/



        //System.out.println(array[5]);



    }

    public static void main4(String[] args) {
        int[] array;
        //array = new int[]{1,2,3};
        array = new int[10];

        //array = {1,2,3,4,5}; error

        boolean[] array2 = new boolean[3];

        String[] words = new String[3];

    }

    public static void main3(String[] args) {
        int[] array = {1,2,3,4,5};

        int[] array2 = new int[]{1,2,3,4,5};


        int[] array3 = new int[5];



        int x = 10;

        //int array2[] = {1,2,3,4,5};

    }

    public static void move(char pos1,char pos2) {
        System.out.print(pos1+" -> "+pos2+" ");
    }

    /**
     *
     * @param n 盘子的个数
     * @param pos1 起始位置
     * @param pos2 中转位置
     * @param pos3 结束位置
     */
    public static void hanoi(int n, char pos1,char pos2,char pos3) {
        if(n == 1) {
            move(pos1,pos3);
            return;
        }
        hanoi(n-1,pos1,pos3,pos2);
        move(pos1,pos3);
        hanoi(n-1,pos2,pos1,pos3);
    }

    public static void main1(String[] args) {
        hanoi(3,'A','B','C');
    }

    public static void func(int x) {
        System.out.println(x);
        System.out.println(x);
        System.out.println(x);
    }

    public static void main2(String[] args) {
        for (int i = 0; i < 100; i++) {
            if(i == 56) {
                System.out.println("hahah!!");
            }
        }
    }
}
