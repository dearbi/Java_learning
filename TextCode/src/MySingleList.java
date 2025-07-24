public class MySingleList {
    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    ListNode head;

    void addFirst(int data) {
        ListNode node = new ListNode(data);//创建出来新的节点
        node.next=head;
        head = node;
    }

    void addEnd(int data) {
        ListNode node = new ListNode(data);
        if(head == null){
            head=node;
            return;
        }
        ListNode cur=head;
        while(cur.next != null){
            cur=cur.next;
        }
        cur.next=node;
    }
    
    void show() {
         ListNode cur=head;
         while(cur != null){
             System.out.print(cur.val+" ");
             cur=cur.next;
         }
    }

}
