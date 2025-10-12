package 反射枚举及lambda表达式;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取数组长度
        System.out.print("请输入数组长度: ");
        int length = scanner.nextInt();

        // 读取数组元素
        int[] nums = new int[length];
        System.out.println("请输入" + length + "个整数，用空格分隔:");
        for (int i = 0; i < length; i++) {
            nums[i] = scanner.nextInt();
        }

        // 读取目标值
        System.out.print("请输入目标值: ");
        int target = scanner.nextInt();

        // 调用四数之和算法
        Solution solution = new Solution();
        List<List<Integer>> result = solution.fourSum(nums, target);

        // 输出结果
        System.out.println("四数之和等于" + target + "的组合有:");
        if (result.isEmpty()) {
            System.out.println("没有找到符合条件的组合");
        } else {
            for (List<Integer> quadruplet : result) {
                System.out.println(quadruplet);
            }
        }

        scanner.close();
    }
}

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int a = 0;
        int n = nums.length;
        for (a = 0; a < n - 3; ) {
            int b = a + 1;
            for (int i = b; i < n - 2; ) {
                int t1 = target - nums[a] - nums[i];
                //求和为t1
                int left = i + 1;
                int right = n - 1;
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum > t1) right--;
                    else if (sum < t1) left++;
                    else {
                        res.add(new ArrayList<Integer>(Arrays.asList(nums[a], nums[i], nums[left], nums[right])));
                        left++;
                        right--;
                        //去重
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    }
                }
                i++;
                while (i < n && nums[i] == nums[i - 1]) i++;
            }
            a++;
            while (a < n && nums[a] == nums[a - 1]) a++;
        }
        return res;
    }
}

