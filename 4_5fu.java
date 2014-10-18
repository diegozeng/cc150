class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    public TreeNode (TreeNode lef, TreeNode rig, int val) {
        this.data = val;
        this.left = lef;
        this.right = rig;
    }
}

class Test45fu {
    public static int last_printed = Integer.MIN_VALUE;
    public static boolean checkBST(TreeNode n) {
        if (n == null) {
            return true;
        }
        if(!checkBST(n.left)) {
            return false;
        }
        if (n.data <= last_printed) {
            return false;
        }
        last_printed = n.data;
        
        if(!checkBST(n.right)) {
            return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        TreeNode n34 = new TreeNode(null, null, 9);
        TreeNode n33 = new TreeNode(null, null, 6);
        TreeNode n32 = new TreeNode(null, null, 4);
        TreeNode n31 = new TreeNode(null, null, 1);
        TreeNode n22 = new TreeNode(n33, n34, 7);
        TreeNode n21 = new TreeNode(n31, n32, 3);
        TreeNode n11 = new TreeNode(n21, n22, 5);
        if(checkBST(n11)) {
            System.out.println("It is a BST!");
        }
        else {
            System.out.println("You are kidding me!");
        }
    }
}