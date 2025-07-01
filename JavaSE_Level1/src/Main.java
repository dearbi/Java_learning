public class Main {
    public static void main(String[] args) {
        int[][] values = {{3, 4, 5, 1}, {33, 6, 1, 2}};
        int v = values[0][0];
        for (int[] list : values) //for-each循环，主要用于访问整个数组
            for (int element : list)
                if (v > element)
                    v = element;
        System.out.print(v);
    }
}