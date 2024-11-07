
class Solution {
    int mod = 1000000007;
    public int countPaths(int[][] grid) {
        int n = grid.length, m= grid[0].length  ;
        int[][] dp = new int[n][m];
        long ans= 0;
        for( int i= 0; i < n; i++)
        {
            for( int j= 0; j < m; j++)
            {
                if( dp[i][j]== 0) 
                {
                   findPathsAt(i,j, dp, grid);
                }
                // to sum all values resolved.
                ans = (ans+dp[i][j])%mod;
            }
        }
        return (int)ans;
    }
    void findPathsAt(int i , int j, int[][] dp , int[][] grid)
    {
        long totalpaths= 0, num = grid[i][j];
        if( i > 0 && grid[i-1][j] < num)
        {
            if( dp[i-1][j] == 0)  findPathsAt(i-1, j, dp , grid);
            totalpaths+= dp[i-1][j];
        }
        if( i < dp.length -1 && grid[i+1][j] < num)
        {
            if( dp[i+1][j] == 0)  findPathsAt(i+1,j, dp , grid);
            totalpaths+= dp[i+1][j];
        }
        if( j > 0 && grid[i][j-1] < num)
        {
            if( dp[i][j-1] == 0)  findPathsAt(i, j-1, dp , grid);
            totalpaths+= dp[i][j-1];
        }
        if( j < dp[0].length -1 && grid[i][j+1] < num)
        {
            if( dp[i][j+1] == 0)  findPathsAt(i,j+1, dp , grid);
            totalpaths+= dp[i][j+1];
        }
        dp[i][j] = (int)(totalpaths+1)%mod;
    }
}