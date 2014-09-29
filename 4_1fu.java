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

class treeBalancefu {
    public static int checkHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = checkHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        
        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
    
    public static boolean isBalanced(TreeNode root) {
        if (checkHeight(root) == -1) {
            return false;
        } else {
            return true;
        }
    }
    
    public static void main (String args[]) {
        TreeNode t43 = new TreeNode(null, null, 9);
        TreeNode t41 = new TreeNode(null, null, 8);
        //TreeNode t34 = new TreeNode(null, null, 7);
        //TreeNode t33 = new TreeNode(null, null, 6);
        TreeNode t32 = new TreeNode(t43, null, 5);
        TreeNode t31 = new TreeNode(t41, null, 4);
        TreeNode t22 = new TreeNode(null, null, 3);
        TreeNode t21 = new TreeNode(t31, t32, 2);
        TreeNode t11 = new TreeNode(t21,t22,1);
        if(isBalanced(t11))
            System.out.println("Balance");
        else
            System.out.println("Not balance");
    }
}