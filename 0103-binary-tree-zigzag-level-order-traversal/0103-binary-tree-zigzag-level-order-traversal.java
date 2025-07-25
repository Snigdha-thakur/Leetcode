class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>();
        if(root==null) return ans;
        boolean b=false;
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> l=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr =q.poll();
                l.add(curr.val);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            if(b==true) Collections.reverse(l);
            ans.add(l);
            b=!b;
        }
        return ans;
    }
}