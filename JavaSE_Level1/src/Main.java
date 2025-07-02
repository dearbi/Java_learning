import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] a = new int[101];
        for (int i = 1; i <= n; i++) {
            a[i] = cin.nextInt();
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
            for (int j = 1; j <= i; j++) {
                if (i == j) {
                    System.out.println(a[j] + " ");
                } else {
                    System.out.print(a[j] + " ");
                }
            }
        }
    }
}