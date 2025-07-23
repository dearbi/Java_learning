package 链表2;
//双向链表
public class MySingleList {
    static class ListNode {
        public int val;
        public ListNode prev;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode head;
    public ListNode node;

    //头插法
    public void addFirst(int data){
        ListNode node=new ListNode(data);
        if(head==null){
            head=node;
        }else{
            node.next=head;
            head.prev=node;
            head=node;
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

    private ListNode search(int index){
        ListNode cur=head;
        int count=0;
        while(count<index){
            cur=cur.next;
            count++;
        }
        return cur;
    }

    //任意位置插⼊,第⼀个数据节点为0号下标
    public void addIndex(int index,int data){
        ListNode node=new ListNode(data);
        if(index==0){
            addFirst(data);
            return;
        }
        if(index<0||index>size()){
            System.out.println("位置不合法");
            return;
        }
        if(index==size()){
            addLast(data);
            return;
        }
        ListNode cur=search(index);
        node.next=cur;
        cur.prev.next=node;
        node.prev=cur.prev;
        cur.prev=node;

    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode cur=head;
        while(cur!=null){
            if(cur.val==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }
    //删除第⼀次出现关键字为key的节点
    public void remove(int key){
        ListNode cur=head;
        while(cur!=null){
            if(cur.val==key){
                if(cur==head){
                    head=cur.next;
                    head.prev=null;
                }else{
                    cur.prev.next=cur.next;
                    if(cur.next!=null){
                        cur.next.prev=cur.prev;
                    }
                }
            }
            cur=cur.next;
        }
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode cur=head;
        while(cur!=null){
            if(cur.val==key){
                if(cur==head){
                    head=cur.next;
                    head.prev=null;
                }else{
                    cur.prev.next=cur.next;
                    if(cur.next!=null){
                        cur.next.prev=cur.prev;
                    }
                }
            }
            cur=cur.next;
        }
    }
    //得到单链表的⻓度
    public int size(){
        int count=0;
        ListNode cur=head;
        while(cur!=null){
            cur=cur.next;
            count++;
        }
        return count;
    }
    public void display(){
        //不要让head动
        ListNode cur=head;
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
    }
    public void clear(){}

}
