import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int res=f(n);
        System.out.println(res);
    }

    public static int  f(int x) {
        //写一个递归方法，输入一个非负整数，返回组成它的数字之和
        if (x < 10) {
            return x;
        } else {
            return x % 10 + f(x / 10);
        }
    }
}
