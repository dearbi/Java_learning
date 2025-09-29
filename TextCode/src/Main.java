import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int x = Integer.parseInt(line[1]);

        int[] a = new int[n + 1];
        String[] nums = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(nums[i - 1]);
        }

        // ✅ 使用 windowSum 表示当前窗口和
        long windowSum = 0;
        int left = 1;
        int minLength = Integer.MAX_VALUE;
        int bestL = -1, bestR = -1;

        for (int right = 1; right <= n; right++) {
            windowSum += a[right];

            while (windowSum >= x && left <= right) {
                int currentLength = right - left + 1;
                if (currentLength < minLength || (currentLength == minLength && left < bestL)) {
                    minLength = currentLength;
                    bestL = left;
                    bestR = right;
                }
                windowSum -= a[left++];
            }
        }

        System.out.println(bestL + " " + bestR);
    }
}
