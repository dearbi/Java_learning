package 接口2.比较相关的接口;

import java.util.Arrays;

public class Test {

    public static void bubbleSort(Comparable[] comparables) {
        for(int i = 0; i < comparables.length-1; i++){
            for (int j = 0; j < comparables.length - 1-i; j++) {
                if(comparables[j].compareTo(comparables[j+1])>0){
                    Comparable comparable=comparables[j];
                    comparables[j]=comparables[j+1];
                    comparables[j+1]=comparable;
                }
            }
        }
    }
    public static void main(String[] args) {
        Student student1 = new Student("bit", 10);
        Student student2 = new Student("hello", 5);
        Student student3 = new Student("gbk", 12);

        Student[] students=new Student[3];
        students[0]=student1;
        students[1]=student2;
        students[2]=student3;
        System.out.println("排序前： "+Arrays.toString(students));
        NameComparator nameComparator = new NameComparator();
        /*Arrays.sort(students,nameComparator);*/
        bubbleSort(students);
        System.out.println("排序后： "+Arrays.toString(students));

        System.out.println("=================");

        if (student1.compareTo(student2) > 0) {
            System.out.println("student1>student2");
        }

//        NameComparator nameComparator = new NameComparator();
        int ret = nameComparator.compare(student1, student2);
        if (ret > 0) {
            System.out.println("student1>student2");
        } else {
            System.out.println("student1<=student2");
        }

        AgeComparator ageComparator = new AgeComparator();
        ret=ageComparator.compare(student1, student2);
        if (ret > 0) {
            System.out.println("student1>student2");
        } else {
            System.out.println("student1<=student2");
        }
    }
}
