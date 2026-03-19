package 顺序表;

import java.util.Scanner;

public class Main {
    static Scanner cin=new Scanner(System.in);
    static final int N=(int)(5e5+10);
    static int n;
    static class Node{
        int[] data;
        int length;
    }

    public static void main(String[] args) {
        Node SeqList = new Node();
        initialList(SeqList);
        System.out.println("初始长度："+SeqList.length);
        System.out.println("末尾插入元素：");
        int x=cin.nextInt();
        insertTail(SeqList,x);//末尾插入
        System.out.println("长度："+SeqList.length);
        System.out.println("指定位置插入元素：");
        int index=cin.nextInt();
        int value=cin.nextInt();
        insertIndex(SeqList,index,value);//指定位置插入
        printList(SeqList);
        System.out.println();
        int e = 0;
        System.out.println("删除指定位置元素：");
        int index2=cin.nextInt();
        e=deleteIndex(SeqList,index2,e);
        System.out.println("删除元素："+e);
        printList(SeqList);

        //翻转
        System.out.println("翻转指定区间：");
        int l=cin.nextInt();
        int r=cin.nextInt();
        reverseList(SeqList,l,r);
        printList(SeqList);

        //后移顺序表
        System.out.println("后移顺序表：");
        int k=cin.nextInt();
        reverseList(SeqList,1,SeqList.length-k);
        reverseList(SeqList,SeqList.length-k+1,SeqList.length);
        reverseList(SeqList,1,SeqList.length);
        printList(SeqList);

    }

    private static void reverseList(Node seqList,int l,int r) {
        for(int i=l;i<=r;i++){
            int temp=seqList.data[i];
            seqList.data[i]=seqList.data[r];
            seqList.data[r]=temp;
            r--;
        }
    }

    private static int deleteIndex(Node seqList, int index, int e) {
        e=seqList.data[index];
        for(int i=index;i<=seqList.length-1;i++){
            seqList.data[i]=seqList.data[i+1];
        }
        seqList.length--;
        return e;
    }

    private static void printList(Node seqList) {
        for(int i=1;i<=seqList.length;i++){
            System.out.print(seqList.data[i]+" ");
        }
    }

    private static void insertTail(Node seqList,int x) {
        seqList.data[seqList.length+1]=x;
        seqList.length++;
    }

    private static void insertIndex(Node seqList,int index,int value) {
        for(int i=seqList.length;i>=index;i--){
            seqList.data[i+1]=seqList.data[i];
        }
        seqList.data[index]=value;
    }

    private static void initialList(Node SeqList) {
        SeqList.data=new int[N];
        SeqList.length=0;
        n=cin.nextInt();
        for(int i=1;i<=n;i++){
            SeqList.data[i]=cin.nextInt();
            SeqList.length++;
        }
    }
}
