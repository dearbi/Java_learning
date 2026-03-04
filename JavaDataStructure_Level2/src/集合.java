import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class 集合 {
    public static void main(String[] args) {
        System.out.println("ArrayList:");
        ArrayList<String> list=new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        for(String s:list) {
            System.out.print(s);
        }
        System.out.println();
        System.out.println("=========");

        System.out.println("HashSet:");
        HashSet<Integer> set =new HashSet<>();//HashSet不会自动排序
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);
        System.out.println(set.size());//会自动去重
        System.out.println(set.contains(1));//判断包不包含
        System.out.println();
        System.out.println("=========");

        System.out.println("LinkedHashSet:");
        LinkedHashSet<Integer> set1 =new LinkedHashSet<>();//按照插入顺序输出
        set1.add(1);
        set1.add(3);
        set1.add(2);
        set1.add(1);
        System.out.println(set.size());//会自动去重
        System.out.println(set.contains(1));//判断包不包含
        for(int i:set1) {
            System.out.println(i);
        }
        System.out.println();
        System.out.println("=========");

        System.out.println("TreeSet:");
        TreeSet<Integer> set2 =new TreeSet<>();//TreeSet会自动排序,默认升序
//	TreeSet<Integer> set2 =new TreeSet<>((x,y)->y-x); 这样是降序
        //
        set2.add(1);
        set2.add(3);
        set2.add(2);
        set2.add(1);
        for(int i:set2) {
            System.out.println(i);
        }
        System.out.println("size:"+set.size());//会自动去重
        System.out.println(set.contains(1));//判断包不包含

        
        
    }
}

