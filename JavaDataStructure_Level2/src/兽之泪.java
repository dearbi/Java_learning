import java.util.PriorityQueue;
import java.util.Scanner;
/**
https://www.lanqiao.cn/courses/52478/learning/?id=4185473&compatibility=false
 **/

public class 兽之泪 {
    // 1. 移除 implements Comparable<Pair> 和 compareTo 方法
    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNext()) return;

        int k = scanner.nextInt();
        int n = scanner.nextInt();
        int[] a = new int[k + 1];
        int[] b = new int[k + 1];

        for (int i = 1; i <= k; ++i) {
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
        }

        long ans1 = 0, ans2 = Long.MAX_VALUE;

        // 2. 在初始化 PriorityQueue 时传入 Lambda 表达式
        // (x, y) -> Integer.compare(x.first, y.first) 表示按 first 字段升序排列
        PriorityQueue<Pair> q = new PriorityQueue<>((x, y) -> Integer.compare(x.first, y.first));

        // ------- 不挑战最后一个怪兽
        for (int i = 1; i < k; ++i) {
            q.offer(new Pair(a[i], i));
        }
        int tmp = n;
        while (tmp > 0) {
            Pair x = q.poll();
            ans1 += x.first;
            q.offer(new Pair(b[x.second], x.second));
            tmp--;
        }

        // ------- 挑战最后一个怪兽
        if (n >= k) {
            ans2 = 0;
            q.clear();
            for (int i = 1; i <= k; ++i) {
                ans2 += a[i];
                q.offer(new Pair(b[i], i));
            }
            n -= k;
            while (n > 0) {
                Pair x = q.poll();
                ans2 += x.first;
                q.offer(new Pair(b[x.second], x.second));
                n--;
            }
        }

        System.out.println(Math.min(ans1, ans2));
        scanner.close();
    }
}