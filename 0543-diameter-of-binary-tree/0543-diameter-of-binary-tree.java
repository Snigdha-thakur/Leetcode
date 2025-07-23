import java.util.*;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxDiameter;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        int left = height(node.left);
        int right = height(node.right);
        maxDiameter = Math.max(maxDiameter, left + right);
        return 1 + Math.max(left, right);
    }

    // Build tree from level order input
    public static TreeNode buildTree(String[] s) {
        if (s.length == 0 || s[0].equals("-1")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;

        while (i < s.length && !q.isEmpty()) {
            TreeNode current = q.poll();

            if (i < s.length) {
                int leftVal = Integer.parseInt(s[i++]);
                if (leftVal != -1) {
                    current.left = new TreeNode(leftVal);
                    q.add(current.left);
                }
            }

            if (i < s.length) {
                int rightVal = Integer.parseInt(s[i++]);
                if (rightVal != -1) {
                    current.right = new TreeNode(rightVal);
                    q.add(current.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        TreeNode root = buildTree(input);
        Solution sol = new Solution();
        System.out.println(sol.diameterOfBinaryTree(root));
    }
}
