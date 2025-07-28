public class Test {
    public static void main(String[] args) {
        List list=new List();
        list.addEnd(1);
        list.addEnd(2);
        list.addEnd(3);
        list.addEnd(4);
        list.addEnd(5);
        List.ListNode ret=list.searchMiddle();
        System.out.println(ret.val);
        System.out.println(list.kthToLast(2));
    }
}
