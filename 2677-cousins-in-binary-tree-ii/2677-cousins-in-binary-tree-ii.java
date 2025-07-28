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
    public TreeNode replaceValueInTree(TreeNode root) {
        if (root==null) {
            return root;
        }

        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> arr = new ArrayList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int sum = 0;
            for (int i = 0;i<size;i++) {
                TreeNode node = q.poll();
                sum+=node.val;
                if (node.left!=null) {q.add(node.left);}
                if (node.right!=null) {q.add(node.right);}
            }
            arr.add(sum);
        }

        q = new LinkedList<>();
        q.add(root);
        int i = 0;
        root.val = (arr.get(i)-root.val);
        i++;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0;j<size;j++) {
                TreeNode node = q.poll();
                if (node.left!=null) {
                    int left = node.left.val;
                    
                    q.add(node.left);
                    if(node.right!=null) {
                        int right = node.right.val;
                        node.left.val = arr.get(i) - left - right;
                    }else {
                        node.left.val = arr.get(i) - left;
                    }
                }
                if (node.right!=null) {
                    int right = node.right.val;
                    q.add(node.right);
                    if(node.left!=null) {
                        node.right.val = node.left.val;
                    }else {
                        
                        node.right.val = arr.get(i) - right;
                    }
                }
            }
            i++;
        }
        return root;
    }
}