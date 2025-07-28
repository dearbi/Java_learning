package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
    public static class TreeNode {
        public char val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char val) {
            this.val=val;
        }
    }

    public TreeNode createTree() {
        //生成A-H的节点
        TreeNode A=new TreeNode('A');
        TreeNode B=new TreeNode('B');
        TreeNode C=new TreeNode('C');
        TreeNode D=new TreeNode('D');
        TreeNode E=new TreeNode('E');
        TreeNode F=new TreeNode('F');
        TreeNode G=new TreeNode('G');
        TreeNode H=new TreeNode('H');

        A.left=B;
        A.right=C;
        B.left=D;
        B.right=E;
        C.left=F;
        C.right=G;
        E.right=H;
        return A;
    }

    // 前序遍历
    public void preOrder(TreeNode root) {
        if(root==null){
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // 中序遍历
    public void inOrder(TreeNode root) {
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

    // 后序遍历
    public void postOrder(TreeNode root) {
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }

    //层序遍历1
    public void levelOrder(TreeNode root){
        if(root==null){
            return;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val+" ");
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
    }
    //层序遍历2
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ret=new ArrayList<>();
        if(root==null){
            return ret;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level=new ArrayList<>();
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }

        }
        return ret;
    }
    // 获取树中节点的个数
    public int nodeSize=0;
    public void size(TreeNode root) {
        if(root==null){
            return;
        }
        nodeSize++;
        size(root.left);
        size(root.right);
    }
    public int size2(TreeNode root) {
        if(root==null){
            return 0;
        }
        return size2(root.left)+size2(root.right)+1;
    }

    // 获取叶子节点的个数
    public int getLeafNodeCount(TreeNode root){
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return getLeafNodeCount(root.left) + getLeafNodeCount(root.right);
    }
    // 获取第K层节点的个数
    public int getKLevelNodeCount(TreeNode root,int k){
        if(root == null){
            return 0;
        }
        if(k==1){
            return 1;
        }
        return getKLevelNodeCount(root.left,k-1)+getKLevelNodeCount(root.right,k-1);
    }
    // 获取⼆叉树的⾼度
    public int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHight=getHeight(root.left);
        int rightHight=getHeight(root.right);

        if(leftHight>=0&&rightHight>=0&&Math.abs(leftHight-rightHight) <= 1){
            return Math.max(leftHight,rightHight)+1;
        }
        return -1;
    }
    // 检测值为value的元素是否存在
    TreeNode find(TreeNode root, int val){
        if(root==null) {
            return null;
        }
        if(root.val==val) {
            return root;
        }
        TreeNode ret=find(root.left,val);
        if(ret!=null) {
            return ret;
        }
        ret=find(root.right,val);
        if(ret!=null) {
            return ret;
        }
        return null;
    }
    //判断两棵树是否相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if((p!=null&&q==null)||(p==null&&q!=null)){
            return false;
        }
        //走到这，要么两个都为空，要么两个都不为空
        if(p==null&&q==null){
            return true;
        }
        if(p.val!=q.val){
            return false;
        }

        //走到这里，p!=null&&q!=null&&p.val==q.val

        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }

    //判断subRoot是不是root的子树
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null){
            return false;
        }
        return isSameTree(root,subRoot)||isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot);
    }

    //翻转二叉树
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
