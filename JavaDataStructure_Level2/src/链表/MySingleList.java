package 链表;

public class MySingleList {
    static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val=val;
        }
    }

    public ListNode head;
/*    public void createList() {
        ListNode node1 = new ListNode(12);
        ListNode node2 = new ListNode(13);
        ListNode node3 = new ListNode(14);
        ListNode node4 = new ListNode(15);
        ListNode node5 = new ListNode(16);

        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;

        this.head = node1;

    }*/

    public void show(){
        //不要让head动
        ListNode cur=head;
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
    }


    //头插法
    public void addFirst(int data){
        ListNode node=new ListNode(data);

        node.next=head;
        head=node;
    }
    //尾插法
    public void addLast(int data){
        ListNode node=new ListNode(data);
        if(head==null){
            head=node;
            return;
        }
        ListNode cur=head;
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=node;
    }
    //任意位置插⼊,第⼀个数据节点为0号下标
    public void addIndex(int index,int data){
        int len=size();
        if(index<0||index>len){
            System.out.println("位置不合法");
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
        ListNode node=new ListNode(data);
        ListNode cur=searchIndex(index);
        node.next=cur.next;
        cur.next=node;
        return;
    }
    private ListNode searchIndex(int index) {
        int len=size();
        if(index<0||index>=len){
            System.out.println("位置不合法");
            return null;
        }
        ListNode cur=head;
        int count=0;
        while(count<index){
            cur=cur.next;
            count++;
        }
        return cur;
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
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
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
    public void clear() {
    }
    public void display() {}
}
