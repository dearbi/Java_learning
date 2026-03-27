import java.util.*;

public class Main {
    static Scanner cin = new Scanner(System.in);

    public static void main(String[] args) {
        int n=cin.nextInt();
        int[] a=new int[n];
        int[] b=new int[n];
        for(int i=0;i<n;i++){
            a[i]=cin.nextInt();
        }
        Arrays.sort(a);
        for(int i=0;i<n;i++){
            b[i]=cin.nextInt();
        }
        Arrays.sort(b);

        long count=0;
        for(int k=0;k<n;k++){
            count+=Math.abs(a[k]-b[k]);
        }
        System.out.println(count);
    }
}