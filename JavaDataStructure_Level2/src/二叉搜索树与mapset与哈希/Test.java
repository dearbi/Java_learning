package 二叉搜索树与mapset与哈希;

public class Test {
    public static void main(String[] args) {
        int[] array = {5, 3, 4, 1, 7, 8, 2, 6, 0, 9};
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for (int i = 0; i < array.length; i++) {
            binarySearchTree.insert(array[i]);
        }
        //查找
        System.out.println(binarySearchTree.search(5));
    }
}
