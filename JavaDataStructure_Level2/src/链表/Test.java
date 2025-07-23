package 链表;

public class Test {
    public static MySingleList.ListNode mergeTwoLists(MySingleList.ListNode list1, MySingleList.ListNode list2) {
        MySingleList.ListNode newH=new MySingleList.ListNode(-1);
        MySingleList.ListNode temp=newH;

        //两个链表都不为空
        while(list1!=null&&list2!=null){
            if(list1.val<list2.val){
                temp.next=list1;
                list1=list1.next;
                // temp=temp.next;
            }else{
                temp.next=list2;
                list2=list2.next;
                // temp=temp.next;
            }
            temp=temp.next;
        }

        if(list1!=null){
            temp.next=list1;
        }
        if(list2!=null){
            temp.next=list2;
        }

        return newH.next;
    }
    public static void printList(MySingleList.ListNode head) {
        MySingleList.ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.addFirst(12);
        mySingleList.addFirst(23);
        mySingleList.addFirst(34);
        mySingleList.addFirst(45);
        mySingleList.addFirst(56);
        MySingleList mySingleList2 = new MySingleList();
        mySingleList2.addFirst(22);
        mySingleList2.addFirst(33);
        mySingleList2.addFirst(44);
        mySingleList2.addFirst(55);
        mySingleList2.addFirst(66);
        MySingleList.ListNode newH=mergeTwoLists(mySingleList.head,mySingleList2.head);
        printList(newH);
    }
    public static void main1(String[] args) {
        MySingleList mySingleList = new MySingleList();
//        mySingleList.createList();
        mySingleList.addFirst(12);
        mySingleList.addFirst(23);
        mySingleList.addFirst(34);
        mySingleList.addFirst(45);
        mySingleList.addFirst(56);

        mySingleList.show();
        System.out.println();
        MySingleList.ListNode ret=mySingleList.middleNode();
        System.out.println(ret.val);
        mySingleList.addLast(19);
        mySingleList.addLast(29);
        mySingleList.show();
        System.out.println();

        mySingleList.remove(34);
        mySingleList.show();
        System.out.println();
        System.out.println(mySingleList.size());
        System.out.println(mySingleList.contains(16));
        mySingleList.clear();

    }
}
