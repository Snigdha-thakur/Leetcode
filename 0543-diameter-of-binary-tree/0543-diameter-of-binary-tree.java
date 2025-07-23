class Solution {
    int maxd = 0;//global 
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        height(root);//calculating heights for every node 
        return maxd;
    }
    int height(TreeNode root){
        if(root == null) return 0;
        int left = height(root.left);//calculating left height 
        int right = height(root.right);//calculating right height
        int cd = left+right;//calculating curret=nt diameter 
        maxd = Math.max(maxd,cd);//calculating max diameter
        return Math.max(left,right)+1;//calculating current height 
    }
}