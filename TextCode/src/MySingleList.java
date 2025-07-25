public class MySingleList {
    static class ListNode{
        int val;
        ListNode next;
        ListNode prev;
        public ListNode(int val) {
            this.val = val;
        }
    }

    ListNode head;

    //头插法
    public void addFirst(int data){
        ListNode node=new ListNode(data);
        if(head == null){
            head=node;
        }else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }
    //尾插法
    public void addLast(int data){
        ListNode node=new ListNode(data);
        if(head==null){
            head=node;
        }else{
            ListNode cur=head;
            while(cur.next!=null){
                cur=cur.next;
            }
            cur.next=node;
            node.prev=cur;
        }
    }


    //在任意位置插入元素
    void addIndex(int index,int data) {
        int len=size();
        if(index < 0 || index > len){
            System.out.println("插入位置不合法");
            return;
        }

        if(index==0){
            addFirst(data);
            return;
        }
        if(index==len){
            addLast(data);
            return;
        }
        ListNode node = new ListNode(data);
        ListNode cur=searchIndex(index);
        node.next=cur;
        cur.prev.next=node;
        node.prev=cur.prev;
        cur.prev=node;
        /*ListNode cur=searchIndex(index);
        node.next=cur.next;
        node.prev=cur;
        cur.next.prev=node;
        cur.next=node;*/
    }

    private ListNode searchIndex(int index) {
        ListNode cur=head;
        int count=0;
        while(count<index){
            count++;
            cur=cur.next;
        }
        return cur;
    }

    //计算链表长度
    private int size() {
        ListNode cur = head;
        int count = 0;
        while(cur !=null){
            count++;
            cur=cur.next;
        }
        return count;
    }


    //查找key的前驱节点
    public ListNode findNodes(int key){
        if(head==null) return null;
        ListNode prev=head;
        while(prev.next!=null){
            if(prev.next.val==key){
                return prev;
            }
            prev=prev.next;
        }
        return null;
    }

    //删除元素
    public void removeAllKeys(int key) {
        if(head==null) return;
        ListNode prev=head;
        ListNode cur = head.next;

        while(cur.next != null){
            if(cur.val==key){
                prev.next=cur.next;
                cur=cur.next;
            }else{
                prev=cur;
                cur=cur.next;
            }
        }

        //单独处理一下开头的节点
        if(head.val==key){
            head=head.next;
        }

    }

    //返回中间节点
    public ListNode middleNode() {
        if(head==null) return null;
        if(head.next==null) return head;
        int len=size();
        ListNode cur=head;
        for(int i=0;i<len/2;i++){
            cur=cur.next;
        }
        return cur;
    }

    void show() {
         ListNode cur=head;
         while(cur != null){
             System.out.print(cur.val+" ");
             cur=cur.next;
         }
        System.out.println();
    }

}
