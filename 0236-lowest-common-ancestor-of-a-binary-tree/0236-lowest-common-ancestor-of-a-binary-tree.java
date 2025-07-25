class Solution {
   public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
   if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        if(root== null){
            return null;
        }

        TreeNode leftAns = lowestCommonAncestor(root.left, p, q);
        TreeNode rightAns = lowestCommonAncestor(root.right, p, q);

        if (leftAns != null && rightAns != null) {
            return root;
        } else if (leftAns != null) {
            return leftAns;
        } else {
            return rightAns;
        }
    }
}