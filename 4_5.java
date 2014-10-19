/**
 * 4.5 Implement a function to check if a binary tree is a binary search tree.
 *
 * 思路: BST符合的条件是对于每个node，左孩子<node<右孩子，而且没有重复的值。设定，min,max为局部的最大/最小值, 随着递归的深入不断更新。对于第一个节点，递归时没有min/max的信息，可用Integer.MIN_VALUE, Integer.MAX_VALUE来替代。 N为节点数，每个循环层只出一个boolean值，因而是logN的空间复杂度。
 *
 * 时间复杂度:O(N)
 * 空间复杂度:O(logN)
 *
 * Follow－up：in-order traverse, if node>node.next, return false（用了额外空间存last_printed，不过更直观）
 * 时间复杂度:O(N)
 * 空间复杂度:O(N)
 */

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

class Test45 {
	public static boolean checkBST(TreeNode n) {
		return checkBST(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean checkBST(TreeNode n, int min, int max) {
		if (n == null) {
			return true; // if n = null, the tree is traversed, all nodes satisfied the requirement 
		}
		if (n.data <= min || n.data > max) {
			return false;
		}
		if (!checkBST(n.left, min, n.data) || !checkBST(n.right, n.data, max)) {
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
