import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> q1=new PriorityQueue<>(Comparator.reverseOrder());
        int[] arr1 = new int[10];
        Scanner sc = new Scanner(System.in);
        int k;
        k=sc.nextInt();
        for (int i = 0; i < 10; i++) {
            arr1[i] = sc.nextInt();
            q1.offer(arr1[i]);
        }
        int[] ret=new int[k];
        for(int i=0;i<k;i++){
            ret[i]=q1.poll();
            System.out.print(ret[i]+" ");
        }
    }
    public static void main1(String[] args) {
        //测试头插法
        MySingleList list=new MySingleList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.show();
        System.out.println("=====");
        //尾差法测试
        MySingleList list2=new MySingleList();
        list2.addLast(1);
        list2.addLast(2);
        list2.addLast(3);
//        list2.addEnd(88);
        list2.show();
        list2.addIndex(1,6);
        list2.show();
//        //查找key节点测试
//        MySingleList.ListNode node=list2.findNodes(6);
//        System.out.println(node.val);
//
//        //返回中间节点测试
//        MySingleList.ListNode node2=list2.middleNode();
//        System.out.println(node2.val);
    }
}