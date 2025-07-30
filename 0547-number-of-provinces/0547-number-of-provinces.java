class Solution {
    public int findCircleNum(int[][] isConnected) {
        int ans = 0;
        boolean visited[] = new boolean[isConnected.length];

        for(int i=0;i<isConnected.length;i++){
            if(!visited[i]){
                depthFirstSearch(i,visited,isConnected);
                ans++;
            }
        }

        return ans;
    }

    void depthFirstSearch(int i,boolean visited[],int[][] isConnected) {
        visited[i] = true;
        for(int j=0;j<isConnected.length;j++){
            if(isConnected[i][j]  == 1 && !visited[j]){
                depthFirstSearch(j,visited,isConnected);
            }
        }
    }

}