class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    public TreeNode(TreeNode left, TreeNode right, int value) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

class Test49 {
    public static void checkSum(TreeNode node, int sum, int[] path, int level){
        if(node == null)
            return;
        path[level]=node.value;
        getPaths(sum,path,level);
        checkSum(node.left, sum,path,level+1);
        checkSum(node.right,sum,path,level+1);
    }
    static void getPaths(int target,int[] path, int level){
        int sum = 0;
        int end = level;
        int start = 0;
        for(int i = level; i>=0;i--){
            sum = sum+path[i];
            if(sum==target){
                start=i;
                printPath(path,start,end);
            }
        }
    }
    static void printPath(int[] path, int start, int end){
        System.out.println("Path:   ");
        for(int i = start; i<= end; i ++){
            System.out.print(path[i]+" ");
        }
        System.out.println("");
    }
    public static int depth(TreeNode node) {
        if (node == null)
            return 0;
        else
            return 1 + Math.max(depth(node.left), depth(node.right));
    }
    
    public static void main(String[] args) {
        TreeNode t43 = new TreeNode(null, null, 2);
        TreeNode t41 = new TreeNode(null, null, 3);
        //TreeNode t34 = new TreeNode(null, null, 7);
        TreeNode t33 = new TreeNode(null, null, 6);
        TreeNode t32 = new TreeNode(t43, null, 5);
        TreeNode t31 = new TreeNode(t41, null, 4);
        TreeNode t22 = new TreeNode(t33, null, 3);
        TreeNode t21 = new TreeNode(t31, t32, 2);
        TreeNode t11 = new TreeNode(t21,t22,1);
        int dep = depth(t11);
        int[] path = new int[dep];
        checkSum(t21, 9, path, 0);
    }
}
