import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

/**
https://www.lanqiao.cn/courses/52478/learning/?id=4185478&compatibility=false
 **/
public class 冷热数据队列 {
    static Scanner cin = new Scanner(System.in);

    public static void main(String[] args) {
        int n1 = cin.nextInt();
        int n2 = cin.nextInt();
        int m = cin.nextInt();

        LinkedHashMap<Integer, Boolean> hotQ = new LinkedHashMap<>();
        LinkedHashMap<Integer, Boolean> coldQ = new LinkedHashMap<>();


        while (m-- > 0) {
            int num = cin.nextInt();

            boolean inHot = hotQ.containsKey(num);
            boolean inCold = coldQ.containsKey(num);

            if (inHot) {
                hotQ.remove(num);
            }
            if (inCold) {
                coldQ.remove(num);
            }

            if (!inHot && !inCold) {
                coldQ.put(num, true);
                if (coldQ.size() > n2) {
                    int first = coldQ.keySet().iterator().next();
                    coldQ.remove(first);
                }
            } else {
                hotQ.put(num, true);
                if (hotQ.size() > n1) {
                    int first2 = hotQ.keySet().iterator().next();
                    hotQ.remove(first2);

                    coldQ.put(first2, true);
                }
            }
        }

        printList(hotQ);
        printList(coldQ);
    }

    private static void printList(LinkedHashMap<Integer, Boolean> map) {
        List<Integer> keys = new ArrayList<>(map.keySet());
        for (int i = keys.size() - 1; i >= 0; i--) {
            System.out.print(keys.get(i) + " ");
        }
        System.out.println();
    }
}
