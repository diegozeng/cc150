/**
 * 3.2 Implement a function to check if a binary tree is balanced. For the purposes of this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any node never differ by more than one.
 *
 * 思路: 判断树的height，利用递归找出max/min height，若差值的绝对值大于1，则不平衡，反之平衡
 *
 * 时间复杂度:O(n^2)（每一个节点会遍历所有的子树，若有n个树，则一共遍历n(n＋1)/2次）
 * 空间复杂度:O(n)
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(TreeNode lchild, TreeNode rchild, int value) {
        this.val = value;
        this.left = lchild;
        this.right = rchild;
    }
}

class treeBalance {
    public static int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        else {
            return Math.max(getHeight(root.left),getHeight(root.right)) + 1;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if(Math.abs(heightDiff) > 1) {
            return false;
        }
        else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }
    
    public static void main (String args[]) {
        TreeNode t43 = new TreeNode(null, null, 9);
        TreeNode t41 = new TreeNode(null, null, 8);
        //TreeNode t34 = new TreeNode(null, null, 7);
        TreeNode t33 = new TreeNode(null, null, 6);
        TreeNode t32 = new TreeNode(t43, null, 5);
        TreeNode t31 = new TreeNode(t41, null, 4);
        TreeNode t22 = new TreeNode(t33, null, 3);
        TreeNode t21 = new TreeNode(t31, t32, 2);
        TreeNode t11 = new TreeNode(t21,t22,1);
        if(isBalanced(t11))
            System.out.println("Balance");
        else
            System.out.println("Not balance");
    }
}