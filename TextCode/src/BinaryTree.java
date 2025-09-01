public class BinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public TreeNode createTree() {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        return node1;
    }

    public void printFirst(TreeNode root) {
        if(root==null){
            return;
        }
        System.out.print(root.val+" ");
        printFirst(root.left);
        printFirst(root.right);
    }
    public void printMiddle(TreeNode root) {
        if(root==null){
            return;
        }
        printMiddle(root.left);
        System.out.print(root.val+" ");
        printMiddle(root.right);
    }
    public void printLast(TreeNode root) {
        if(root==null){
            return;
        }
        printLast(root.left);
        printLast(root.right);
        System.out.print(root.val+" ");
    }
    public TreeNode searchIndex(TreeNode root,int val) {
        if(root==null){
            return null;
        }
        if(root.val==val){
            return root;
        }
        TreeNode cur=searchIndex(root.left,val);
        if(cur!=null){
            return cur;
        }
        cur=searchIndex(root.right, val);
        if(cur!=null){
            return cur;
        }
        return null;
    }
}
