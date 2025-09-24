package 排序;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        set.add("hello");
        set.add("world");
        set.add("java");
        set.add("python");
        set.add("c++");
        set.add("c");
        for(String str : set)
        {
            System.out.println(str);
        }
        System.out.println(set);
    }
    public static void main2(String[] args) {
        Map<String,Integer> map = new TreeMap<>();
        //根据key排序
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        map.put("6", 6);

        Set<Map.Entry<String, Integer>> set = map.entrySet();
        for(Map.Entry<String, Integer> entry : set)
        {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        Integer val=map.get("1");
        System.out.println(val);
        map.remove("1");
        System.out.println(map);
    }
    public static void main1(String[] args) {
        int[] array = {6,1,2,6,9,3,4,6,10,6};
        Sort sort = new Sort();
        sort.quickSort(array);
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
    }
}
