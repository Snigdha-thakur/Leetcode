class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        findPaths(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    void findPaths(TreeNode node, int sum, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return;

        path.add(node.val);

        if (node.left == null && node.right == null && node.val == sum) {
            result.add(new ArrayList<>(path));
        } else {
            findPaths(node.left, sum - node.val, path, result);
            findPaths(node.right, sum - node.val, path, result);
        }

        path.remove(path.size() - 1);
    }
}
