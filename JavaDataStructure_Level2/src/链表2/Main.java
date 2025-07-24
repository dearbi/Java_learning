package 链表2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        // 构造⼀个空的LinkedList
        List<Integer> list1 = new LinkedList<>();
        List<String> list2 = new ArrayList<>();
        list2.add("JavaSE");
        list2.add("JavaWeb");
        list2.add("JavaEE");
        // 使⽤ArrayList构造LinkedList
        List<String> list3 = new LinkedList<>(list2);
        System.out.println(list2);
        System.out.println(list3);
        ListIterator<String> it = list2.listIterator() ;
        while (it.hasNext()) {
            //打印
            System.out.print(it.next()+" ");
        }
    }
}
