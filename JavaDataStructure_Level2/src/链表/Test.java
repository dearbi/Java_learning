package 链表;

public class Test {
    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
//        mySingleList.createList();
        mySingleList.addFirst(12);
        mySingleList.addFirst(23);
        mySingleList.addFirst(34);
        mySingleList.addFirst(45);
        mySingleList.addFirst(56);

        mySingleList.show();
        System.out.println();
        mySingleList.addLast(19);
        mySingleList.addLast(29);
        mySingleList.show();
        System.out.println();
        System.out.println(mySingleList.size());
        System.out.println(mySingleList.contains(16));

    }
}
