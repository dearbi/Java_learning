package 链表2;

public class Test {
    public static void main(String[] args) {
        //头插测试
        MySingleList list = new MySingleList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);
        list.addFirst(6);
        list.display();
        System.out.println();
        //尾差测试
        list.addLast(7);
        list.addLast(8);
        list.addLast(9);
        list.display();
        System.out.println();
        //删除所有值为key的节点
        list.removeAllKey(5);
        list.display();

    }
}
