/**
 * 4.3  Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 *
 * 思路: 将BFS的思想用在树上，利用Queue逐层遍历，由于树的孩子只有一个parent，所以遍历的时候不用担心重复的问题。最后的结果以LinkedList的形式存在一个ArrayList里，其index表示树的深度.
 *
 * 时间复杂度:O(N)
 * 空间复杂度:O(N)
 *
 * 注：N为树的节点数
 */

import java.util.LinkedList;
import java.util.ArrayList;

class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
    public TreeNode(TreeNode lef, TreeNode rig, int v) {
		this.val = v;
		this.left = lef;
		this.right = rig;
	}
}

class Test44 {
    public static ArrayList<LinkedList<TreeNode>> createLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        if (root != null) {
            current.add(root);
        }
        
        while (current.size() > 0) {
            result.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<TreeNode>();
            for (TreeNode parent : parents) {
                if (parent.left != null) {
                    current.add(parent.left);
                } if (parent.right != null) {
                    current.add(parent.right);
                }
            }
        }
        return result;
    }
    
    public static void main (String args[]) {
        TreeNode t43 = new TreeNode(null, null, 8);
        TreeNode t41 = new TreeNode(null, null, 7);
        //TreeNode t34 = new TreeNode(null, null, 7);
        TreeNode t33 = new TreeNode(null, null, 6);
        TreeNode t32 = new TreeNode(t43, null, 5);
        TreeNode t31 = new TreeNode(t41, null, 4);
        TreeNode t22 = new TreeNode(t33, null, 3);
        TreeNode t21 = new TreeNode(t31, t32, 2);
        TreeNode t11 = new TreeNode(t21,t22,1);
        ArrayList<LinkedList<TreeNode>> res = createLinkedList(t11);
        for (int i = 0; i < res.size(); i++) {
            System.out.print("第" + i + "层的节点是: ");
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j).val);
            }
            System.out.println(" ");
        }
    }
}
