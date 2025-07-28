class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] hash=new int[n+1];
        for(int []arr:trust){
            hash[arr[0]]--;
            hash[arr[1]]++;
        }
        int count=0;
        for(int i=1;i<=n;i++)
        if(hash[i]==n-1)
        return i;
        return -1;
    }
}