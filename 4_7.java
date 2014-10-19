//思路: 如果可以用 parent 指针，就可以一直向上搜索知道其相遇(参照4.6的算法)，不过需要用到额外的数据结构。
//若不用 parent 指针，assume p and q 是 input nodes
class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
	public TreeNode(int value, TreeNode left, TreeNode right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
}

class Test47 {
    //定义是否contain/cover的方法（供中间层调用），最内层递归
    public static boolean covers(TreeNode root, TreeNode p) {
        if (root == null)//递归退出条件一: 遍历了所有孩子，没有一个孩子是p
            return false;
        if (root == p)) //递归退出条件二: 遍历发现p是其中一个后代
            return true;
        return covers(root.left, p) || covers(root.right, p);//递归体
    }
    
    // 找共同祖先，中间层递归.
    public static TreeNode commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root = null)//递归退出条件一: 遍历了所有孩子，没有一个孩子是p或q
            return null;
        if (root == p || root == q)//递归退出条件二: 遍历发现p或者q，直接返回p或q作为共同祖先
            return root;
        
        boolean is_p_on_left = covers(root.left, p);
        boolean is_q_on_left = covers(root.left, q);
        
        if(is_p_on_left != is_p_on_left)//递归退出条件三: 遍历发现p和q不在一边，则返回当前点即为共同祖先
            return root;
        TreeNode child_side = is_q_on_left ? root.left : root.right;
        return commonAncestorHelper(child_side, p, q);//递归体
    }
    
    // 判断p和q是否在同一棵树上，最外层递归.
    public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (!covers(root, p) || !covers(root,q)) { //递归退出条件: p和q中有至少一个不在root对应的这棵树上
            return null;
        }
        return commonAncestorHelper(root, p, q);//递归体: 排除情况后进入下一层递归commonAncestorHelper
    }
}