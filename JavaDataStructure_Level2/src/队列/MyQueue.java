package 队列;

public class MyQueue {


    // 双向链表节点
    public static class ListNode{
        ListNode next;
        ListNode prev;
        int val;
        ListNode(int val){
            this.val = val;
        }
    }
    public ListNode head;
    public ListNode last; // 队尾
    int usedSize = 0;



    //删去头结点
    public int poll() {
        if(head==null){
            return -1;
        }
        int val=head.val;
        if(head.next==null){
            head=null;
            last=null;
        }else{
            head=head.next;
            head.prev=null;
        }
        usedSize--;
        return val;
    }

    public int peek(){
        if(head==null){
            return -1;
        }
        return head.val;
    }

    //尾插
    public void offer(int val){
        ListNode node=new ListNode(val);
        if(head==null){
            head = node;
            last = node;
        }else{
            last.next = node;
            node.prev=last;
            last=last.next;
        }
    }
    public int size() {
        //计算长度
        return usedSize;
    }




}
