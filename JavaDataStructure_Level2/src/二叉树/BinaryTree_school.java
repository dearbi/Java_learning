package 二叉树;

import java.util.Map;
import java.util.Scanner;

public class BinaryTree_school {
    static Scanner cin=new Scanner(System.in);
    static class BitNode{
        char data;
        BitNode left;
        BitNode right;

    }

    //先序创建二叉树
    public static BitNode create1(){
        if(!cin.hasNext()) return null;

        String s=cin.next();
        char ch=s.charAt(0);

        if(ch=='#') return null;

        BitNode root=new BitNode();
        root.data=ch;
        root.left=create1();
        root.right=create1();
        return root;
    }

    //先序遍历
    public static void preOrder(BitNode root){
        if(root!=null){
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    //中序遍历
    public static void inOrder(BitNode root){
        if(root!=null){
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
    }

    //后序遍历
    public static void postOrder(BitNode root){
        if(root!=null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }
    }


    //求深度
    public static int depth(BitNode root){
        if(root==null) return 0;
        int d1=depth(root.left);
        int d2=depth(root.right);

        return Math.max(d1,d2)+1;
    }

    //求叶子节点个数
    public static int leaf(BitNode root){
        int count=0;
        if(root!=null){
            if(root.left==null&&root.right==null) count++;
            count+=leaf(root.left);
            count+=leaf(root.right);
        }
        return count;
    }

    //先序中序还原二叉树
    public static BitNode rebuild1(char[] pre,int preStart,int preEnd,char[] in,int inStart,int len){
        if(len==0) return null;
        BitNode root=new BitNode();
        root.data=pre[preStart];
        int i=inStart;
        for(;i<inStart+len;i++){
            if(pre[preStart]==in[i]) break;
        }
        int leftLen=i-inStart;
        int rightLen=len-leftLen-1;
        root.left=rebuild1(pre,preStart+1,preStart+leftLen,in,inStart,leftLen);
        root.right=rebuild1(pre,preStart+leftLen+1,preEnd,in,i+1,rightLen);
        return root;
    }

    // 后序中序还原二叉树
    // 参数说明：post(后序数组), postStart(后序起始下标), in(中序数组), inStart(中序起始下标), len(当前子树长度)
    public static BitNode rebuild2(char[] postOrder, int postStart, char[] inOrder, int inStart, int len) {
        if (len == 0) return null;

        BitNode root = new BitNode();

        // 1. 后序遍历的最后一个元素是根节点
        root.data = postOrder[len - 1];

        // 2. 在中序遍历中找到根节点的位置
        int i = inStart;
        for (; i < inStart + len; i++) {
            if (postOrder[postStart + len - 1] == inOrder[i]) break;
        }

        // 3. 计算左右子树的长度
        int leftLen = i - inStart;       // 左子树长度
        int rightLen = len - leftLen - 1; // 右子树长度

        // 4. 递归构建左子树
        // 后序起始点不变，长度为 leftLen
        root.left = rebuild2(postOrder, postStart, inOrder, inStart, leftLen);

        // 5. 递归构建右子树
        // 中序起始点 = 当前中序起始点 + 左子树长度 + 1 (跳过根节点)
        root.right = rebuild2(postOrder, postStart + leftLen, inOrder, inStart + leftLen + 1, rightLen);

        return root;
    }



    public static void main(String[] args) {
//        BitNode root=create1();
//        System.out.println("先序遍历:");
//        preOrder(root);
//        System.out.println();
//        System.out.println("中序遍历:");
//        inOrder(root);
//        System.out.println();
//        System.out.println("后序遍历:");
//        postOrder(root);
//        System.out.println();
//        System.out.println("深度:"+depth(root));
//        System.out.println("叶子节点个数:"+leaf(root));

        System.out.println("先序中序还原二叉树:");
        BitNode root1=rebuild1(new char[]{'A','B','D','E','C','F','G'},0,6,new char[]{'D','B','E','A','F','C','G'},0,7);
        preOrder(root1);
        System.out.println();
        System.out.println("后序中序还原二叉树:");
        BitNode root2=rebuild2(new char[]{'D','B','E','A','F','C','G'},0,new char[]{'D','B','E','A','F','C','G'},0,7);
        preOrder(root2);
        System.out.println();
    }
}
