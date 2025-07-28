/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        // 3 cases deleting => leaf node, node with single child, node with two children
        if (root == null)
            return null;

        if (root.val == key) {
            if (root.left == null && root.right == null) {
                // leaf node case
                return null;
            } else if (root.left == null || root.right == null) {
                // node with single child
                return root.left == null ? root.right : root.left;
            } else {
                // node with both childs
                // we need either greatest from LST or smallest from RST
                TreeNode greatestInLST = root.left;
                greatestInLST = findGreatestInLST(greatestInLST);
                root.val = greatestInLST.val;
                
                // delete that greatest guy in LST from LST and assign back to left subtree of root (v v imp)
                root.left = deleteNode(root.left, greatestInLST.val);
            }
        } else if (root.val < key) {
            // if key > root delete from RST
            root.right = deleteNode(root.right, key);
        } else {
            // else delete from LST
            root.left = deleteNode(root.left, key);
        }

        return root;
    }

    static TreeNode findGreatestInLST(TreeNode root) {
        // right most node in LST
        if (root.right == null)
            return root;

        return findGreatestInLST(root.right);
    }
}