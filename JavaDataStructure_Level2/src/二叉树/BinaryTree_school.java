package 二叉树;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BinaryTree_school {
    static Scanner cin=new Scanner(System.in);
    static class TreeNode{
        char data;
        TreeNode left;
        TreeNode right;

    }

    //先序创建二叉树(中间带空格）
    public static TreeNode create1(){
        if(!cin.hasNext()) return null;

        String s=cin.next();
        char ch=s.charAt(0);

        if(ch=='#') return null;

        TreeNode root=new TreeNode();
        root.data=ch;
        root.left=create1();
        root.right=create1();
        return root;
    }
    //先序创建二叉树（中间不带空格）
//    private static TreeNode createTree(String s) {
//        if(index>=s.length()) return null;
//
//        char ch=s.charAt(index);
//        index++;
//
//        if(ch=='#') return null;
//        TreeNode root=new TreeNode();
//        root.data=ch;
//        root.left=createTree(s);
//        root.right=createTree(s);
//
//        return root;
//    }

    //先序遍历
    public static void preOrder(TreeNode root){
        if(root!=null){
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    //中序遍历
    public static void inOrder(TreeNode root){
        if(root!=null){
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
    }

    //后序遍历
    public static void postOrder(TreeNode root){
        if(root!=null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }
    }

//层序遍历
//	private static void printLevelOrder(TreeNode root) {
//		if(root==null) return;
//
//		Queue<TreeNode> q=new LinkedList<>();
//		q.offer(root);
//
//		StringBuilder sb=new StringBuilder();
//
//		while(!q.isEmpty()){
//			TreeNode current=q.poll();
//			if(!isFrist) sb.append(" ");
//			sb.append(current.data);
//			isFrist=false;
//
//			if(current.left!=null){
//				q.offer(current.left);
//			}
//			if(current.right!=null){
//				q.offer(current.right);
//			}
//		}
//
//		System.out.println(sb.toString());
//	}

    //求深度
    public static int depth(TreeNode root){
        if(root==null) return 0;
        int d1=depth(root.left);
        int d2=depth(root.right);

        return Math.max(d1,d2)+1;
    }

    //求叶子节点个数
    public static int leaf(TreeNode root){
        int count=0;
        if(root!=null){
            if(root.left==null&&root.right==null) count++;
            count+=leaf(root.left);
            count+=leaf(root.right);
        }
        return count;
    }

    //先序中序还原二叉树
    private static TreeNode rebuild1(String preOder, int preStart, int preEnd, String inOrder, int inStart, int inEnd) {
        if(preStart>preEnd||inStart>inEnd){
            return null;
        }

        char rootVal=preOder.charAt(preStart);
        TreeNode root=new TreeNode();
        root.data=rootVal;

        //找到中序遍历中根节点的位置
        int rootIndex=0;
        for(int i=inStart;i<=inEnd;i++){
            if(inOrder.charAt(i)==rootVal){
                rootIndex=i;
                break;
            }
        }

        //计算左子树的数量
        int leftSubTreeCount=rootIndex-inStart;

        root.left=rebuild1(preOder,preStart+1,preStart+leftSubTreeCount,inOrder,inStart,rootIndex-1);

        root.right=rebuild1(preOder,preStart+leftSubTreeCount+1,preEnd,inOrder,rootIndex+1,inEnd);
        return  root;
    }

    // 后序中序还原二叉树
    // 参数说明：post(后序数组), postStart(后序起始下标), in(中序数组), inStart(中序起始下标), len(当前子树长度)
    private static TreeNode rebuild2(String inOrder, int inStart, int inEnd, String postOrder, int postStart, int postEnd) {
        // 1. 递归终止条件
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        // 2. 确定根节点：后序遍历的最后一个元素是当前子树的根
        char rootVal = postOrder.charAt(postEnd);
        TreeNode root = new TreeNode();
        root.data = rootVal;

        // 3. 找到中序遍历中根节点的位置
        int rootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder.charAt(i) == rootVal) {
                rootIndex = i;
                break;
            }
        }

        // 4. 计算左子树在中序遍历中的节点数量
        // 这个数量用于推算后序遍历中左右子树的分界线
        int leftSubTreeCount = rootIndex - inStart;

        // 5. 递归构建左子树
        // 中序范围：[inStart, rootIndex - 1]
        // 后序范围：[postStart, postStart + leftSubTreeCount - 1]
        root.left = rebuild2(inOrder, inStart, rootIndex - 1, postOrder, postStart, postStart + leftSubTreeCount - 1);

        // 6. 递归构建右子树
        // 中序范围：[rootIndex + 1, inEnd]
        // 后序范围：[postStart + leftSubTreeCount, postEnd - 1] (注意：postEnd-1 是去掉当前根节点)
        root.right = rebuild2(inOrder, rootIndex + 1, inEnd, postOrder, postStart + leftSubTreeCount, postEnd - 1);

        return root;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
    }
}
