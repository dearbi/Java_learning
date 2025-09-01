import java.util.PriorityQueue;

class Student implements Comparable<Student> {
    public int age;

    public Student(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
        return o.age - this.age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                '}';
    }
}

public class Test {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(1);
        priorityQueue.add(2);
        priorityQueue.add(3);
        priorityQueue.add(100);

        System.out.println(priorityQueue.peek());


        PriorityQueue<Student> priorityQueue2 = new PriorityQueue<>();
        priorityQueue2.offer(new Student(10));
        priorityQueue2.offer(new Student(12));
        System.out.println(priorityQueue2.peek());

    }

    public static void main1(String[] args) {
        BinaryTree root = new BinaryTree();
        BinaryTree.TreeNode listNode = root.createTree();
        root.printFirst(listNode);
        System.out.println();
        root.printMiddle(listNode);
        System.out.println();
        root.printLast(listNode);
        System.out.println();
        BinaryTree.TreeNode cur = root.searchIndex(listNode, 3);
        System.out.println(cur.val);
    }

    public int[] smallestK(int[] arr, int k) {
        if (arr == null || k <= 0) {
            return null;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(arr[i]);
        }

        for (int i = k; i < arr.length; i++){
            if (arr[i] < priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.offer(arr[i]);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = priorityQueue.poll();
        }
        return res;
    }

}
