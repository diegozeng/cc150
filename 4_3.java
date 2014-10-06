/**
 * 4.3 Given a sorted (increasing order) array with unique integer elements, write an algo- rithm to create a binary search tree with minimal height.
 *
 * 思路: 严格按照二分法的定义，递归求出所有节点（int强制转换取的是下限）
 *
 * 时间复杂度:O(n)［lg(T(N)) = 1 + lg(T(N/2)) => lg(T(N)) = lgN => T(N) = N)］
 * 空间复杂度:O(n)
 *
 * 注：BST的查找删除一类的操作时间复杂度都是O(logn)，如果是此题的情况，构建一个BST，时间复杂度是O(n)
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
    public TreeNode(int value) {
        this.val = value;
    }
}

class Test43 {
    static TreeNode createMinimalBST(int arr[], int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode n = new TreeNode(arr[mid]);
        n.left = createMinimalBST(arr, start, mid - 1);
        n.right = createMinimalBST(arr, mid + 1, end);
        return n;
    }
    
    static TreeNode createMinimalBST(int array[]) {
        return createMinimalBST(array, 0, array.length - 1);
    }
    
    public static void main(String[] args) {
        int a[] = new int[9];
        for(int i = 0; i < a.length; i++)
        {
            a[i] = i + 1;
        }
        TreeNode m = createMinimalBST(a);
        System.out.println(m.val);
        System.out.println(m.left.val + " " + m.right.val);
        System.out.println(m.left.left.val + " " + m.left.right.val + " " + m.right.left.val + " " + m.right.right.val);
        System.out.println(m.left.right.right.val + " " + m.right.right.right.val);
    }
}