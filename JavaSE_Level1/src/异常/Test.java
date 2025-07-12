package 异常;

public class Test {

    public static void main(String[] args) {
        try {
            int[] array = {1, 2, 3, 4, 5};
            array[6] = 100;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("捕获了数组下标越界异常");
            e.printStackTrace();
        }
    }
    public static int getElement(int[] array, int index) {
        if (null == array) {
            throw new NullPointerException("传递的数组为null");
        }
        if (index < 0 || index >= array.length) {
            throw new ArrayIndexOutOfBoundsException("传递的数组下标越界");
        }
        return array[index];
    }

    public static void main1(String[] args) {
        int[] array = {1, 2, 3};
        getElement(array, 3);
    }

}

