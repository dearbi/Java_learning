package 二叉树;

public class Test {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.TreeNode root=binaryTree.createTree();

        binaryTree.preOrder(root);
        System.out.println();
        binaryTree.inOrder(root);
        System.out.println();
        binaryTree.postOrder(root);
        System.out.println();
        binaryTree.size(root);
        System.out.println(binaryTree.nodeSize);
        System.out.println(binaryTree.size2(root));
        System.out.println(binaryTree.getLeafNodeCount(root));
        System.out.println(binaryTree.getKLevelNodeCount(root,2));
        System.out.println(binaryTree.getHeight(root));

    }
}
