import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // 消耗掉整数后的换行符
        String str1 = scanner.next();
        String str2 = scanner.next();
        scanner.nextLine(); // 消耗掉两个字符串后的换行符

        int lastStr1Index = -1;
        int lastStr2Index = -1;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            String currentStr = scanner.nextLine();

            if (currentStr.equals(str1)) {
                lastStr1Index = i;
                // 如果str2之前出现过，计算距离
                if (lastStr2Index != -1) {
                    minDistance = Math.min(minDistance, lastStr1Index - lastStr2Index);
                }
            } else if (currentStr.equals(str2)) {
                lastStr2Index = i;
                // 如果str1之前出现过，计算距离
                if (lastStr1Index != -1) {
                    minDistance = Math.min(minDistance, lastStr2Index - lastStr1Index);
                }
            }
        }

        // 判断str1或str2是否不存在
        if (lastStr1Index == -1 || lastStr2Index == -1) {
            System.out.println(-1);
        } else {
            System.out.println(minDistance);
        }

        scanner.close();
    }
}