class Solution {
    int res = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        traverse(root);
        return res;
    }

    int traverse(TreeNode root) {
        if (root== null) return 0;

        int left = Math.max(traverse(root.left), 0);//gor neglecting -ve numbers we will compare with zero.
        int right = Math.max(traverse(root.right), 0);
        int pathsum= root.val+left+right;//cur path sum
        res= Math.max(res, pathsum);
        return root.val+Math.max(left,right);
    }
}