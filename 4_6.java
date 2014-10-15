/**
 * 4.6 Write an algorithm to find the 'next' node (i.e., in-order successor) of a given node in a binary search tree. You may assume that each node has a link to its parent.
 *
 * 思路: 1.一个节点有右孩子，则在中序遍历中，该节点的后继是它的右子树的最左节点。
        2. 这个节点是它父亲的左孩子，则该节点的后继节点是它的父亲
        3. 这个节点是它父亲的右孩子，则需要一直向上搜索，直到它们n-1代祖先是它第n代祖先的左孩子，则它的后继就是第n个祖先。如果一直搜索到根节点，也没有找到n-1代祖先是它第n代祖先的左孩子，则该节点是整个树的中序遍历中的最后一个节点，即它没有后继，返回null
        2和3可以合并, 定义树节点要额外加一个parent成员。
 *
 * 时间复杂度:O(d)
 * 空间复杂度:O(1)
 *
 * 注：d为树的深度ß
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode parent;
	public TreeNode(TreeNode lef, TreeNode rig, TreeNode par, int v) {
		this.val = v;
		this.left = lef;
		this.right = rig;
		this.parent = par;
	}
	public TreeNode() {}
}

class Test46 {
	public static TreeNode inorderSucc(TreeNode anyNode) {
		if(anyNode.right != null) {
			TreeNode anyNoderig = anyNode.right;
			return leftMost(anyNoderig);
		} else {
			TreeNode q = anyNode;
			TreeNode x = q.parent;
			while(x != null && x.left != q) {
				q = x;
				x = x.parent;
			}
			return x;
		}

	}
	
	public static TreeNode leftMost(TreeNode aNode) {
		if(aNode == null)
			return null;
		while(aNode.left != null) {
			aNode = aNode.left;
		}
		return aNode;
	}

	public static void main(String[] args) {
		TreeNode n11 = new TreeNode();
		TreeNode n21 = new TreeNode();
		TreeNode n22 = new TreeNode();
		TreeNode n31 = new TreeNode();
		TreeNode n32 = new TreeNode();
		TreeNode n33 = new TreeNode();
		TreeNode n34 = new TreeNode();
		n11.val = 5;
		n11.left = n21;
		n11.right = n22;
		n11.parent = null;
		n21.val = 3;
		n21.left = n31;
		n21.right = n32;
		n21.parent = n11;
		n22.val = 7;
		n22.left = n33;
		n22.right = n34;
		n22.parent = n11;
		n31.val = 2;
		n31.left = null;
		n31.right = null;
		n31.parent = n21;
		n32.val = 4;
		n32.left = null;
		n32.right = null;
		n32.parent = n21;
		n33.val = 6;
		n33.left = null;
		n33.right = null;
		n33.parent = n22;
		n34.val = 8;
		n34.left = null;
		n34.right = null;
		n34.parent = n22;
		TreeNode theNode = n33; 
		TreeNode nextNode = inorderSucc(theNode);
		System.out.println("The node with value "+ nextNode.val  +  " is the next of the node with value " + theNode.val);
	}
}

