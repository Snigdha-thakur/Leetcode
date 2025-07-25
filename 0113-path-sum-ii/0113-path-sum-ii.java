class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        traverse(root,res,new ArrayList<>(),targetSum);
        return res;// return list of list o/p
    }
    void traverse(TreeNode root, List<List<Integer>> res, List<Integer> path, int targetSum){
        if(root== null) return;
        path.add(root.val);
        if(root.left== null && root.right== null && targetSum-root.val==0){
            res.add(new ArrayList<>(path));
        }
        else{
            traverse(root.left,res,path,targetSum-root.val);
            traverse(root.right,res,path,targetSum-root.val);
        }
        path.remove(path.size()-1);//last element should be removed to backtrack
    }
}