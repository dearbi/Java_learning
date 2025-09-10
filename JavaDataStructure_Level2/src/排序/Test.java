package 排序;

public class Test {
    public static void main(String[] args) {
        int[] array = {6,1,2,6,9,3,4,6,10,6};
        Sort sort = new Sort();
        sort.quickSort(array);
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
    }
}
