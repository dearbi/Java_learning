public class List {
    public static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    ListNode head;

    public void addFirst(int val) {
        ListNode node=new ListNode(val);
        node.next=head;
        head=node;
    }

    public void addEnd(int val) {
        ListNode node=new ListNode(val);
        if(head==null){
            head=node;
        }else{
            ListNode cur = head;
            while(cur.next!=null){
                cur=cur.next;
            }
            cur.next=node;
        }
    }

    public ListNode searchMiddle(){
        ListNode fast=head;
        ListNode slow=head;

        if(head==null) return null;
        while(fast!=null&&fast.next !=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public int kthToLast(int k) {
        if(head==null) return 0;
        ListNode cur=head;
        int count=0;
        while(cur!=null){
            cur=cur.next;
            count++;
        }
        cur=head;
        int n=count-k;
        while(n!=0){
            cur=cur.next;
            n--;
        }
        return cur.val;
    }
}
