class Solution {
    List<Integer> l = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
        return l.get(k - 1);
    }

    void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        l.add(root.val);
        inorder(root.right);
    }
}
