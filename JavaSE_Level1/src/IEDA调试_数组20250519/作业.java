package IEDA调试_数组20250519;

import java.util.Arrays;

public class 作业 {
    //1
    public static void fuc(int[] a) {
        a[0] *= 2;
        a[1] *= 2;
        a[2] *= 2;
    }

    public static void main1(String[] args) {
        int[] a = {1, 2, 3};
        fuc(a);
        System.out.println(Arrays.toString(a));
    }

    //2
    public static void swap(int x,int y)
    {
        int temp=x;
        x=y;
        y=temp;
    }
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        for(int i=0;i<a.length-1; i++)
        {
            if(a[i]%2==0&&a[i+1]%2!=0)
            {
                int temp=a[i];
                a[i]=a[i+1];
                a[i+1]=temp;;
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
