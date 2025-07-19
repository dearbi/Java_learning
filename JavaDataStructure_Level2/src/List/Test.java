package List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList= new ArrayList<>();
        List<Integer> list =new ArrayList<>();
    }
    public static void main2(String[] args) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        System.out.println(arrayList);

        List list=arrayList.subList(1,4);
        list.set(0, 22);
        System.out.println(list);
        System.out.println(arrayList);
    }
    public static void main1(String[] args) {
        MyArrayList list = new MyArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(99);

        list.add(1, 199);
        list.display();

//        System.out.println(list.get(15));

/*        System.out.println(list.contains(5));
        System.out.println(list.indexOf(5));*/
        list.set(6,88);
        list.display();

    }
}
