package 二叉搜索树与mapset与哈希;

public class BinarySearchTree {
    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode root;

    /**
     * 查找
     * @param val
     * @return
     */
    public boolean search(int val) {
        if (root == null) {
            return false;
        }
        if (root.val == val) {
            return true;
        }
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val < val) {
                cur = cur.right;
            } else if (cur.val > val) {
                cur = cur.left;
            } else {
                return true;
            }
        }
        return false;
    }
    /**
     * 插入
     * @param val
     */
    public void insert(int val) {
        if (root == null) {
            root = new TreeNode(val);
            return;
        }
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur != null) {
            if (cur.val < val) {
                parent = cur;
                cur = cur.right;
            } else if (cur.val > val) {
                parent = cur;
                cur = cur.left;
            } else {
                return;
            }
        }
        TreeNode node = new TreeNode(val);
        if (parent.val < val) {
            parent.right = node;
        } else {
            parent.left = node;
        }
    }

    /**
     * 删除
     * @param val
     */
    public void remove(int val) {
        TreeNode cur= root;
        TreeNode parent = null;
        while (cur != null) {
            if (cur.val < val) {
                parent = cur;
                cur = cur.right;
            } else if (cur.val > val) {
                parent = cur;
                cur = cur.left;
            } else {
                //删除
                removeNode(cur,parent);
                return;
            }
        }
    }
    /**
     * 删除
     * @param cur 要删除的节点
     * @param parent 要删除的节点的父节点
     */
    private void removeNode(TreeNode cur, TreeNode parent) {
        if (cur.left == null) {
            if(cur==root){
                root=cur.right;
            }
            else if (cur == parent.left) {
                parent.left = cur.right;
            } else{
                parent.right=cur.right;
            }
        }
        else if (cur.right == null) {
            if (cur == root) {
                root = cur.left;
            } else if (cur == parent.left) {
                parent.left = cur.left;
            } else {
                parent.right = cur.left;
            }
        }
        else{
            TreeNode targetParent=cur;
            TreeNode target=cur.right;
            while(target.left!=null){
                targetParent=target;
                target=target.left;
            }
            cur.val=target.val;
            if(targetParent.left==target){
                targetParent.left=target.right;
            }
            else{
                targetParent.right=target.right;
            }
        }
    }
}