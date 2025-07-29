class Solution {
    public int numIslands(char[][] grid) {
        int c = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == '1'){
                    c++;
                    solve(grid, i, j);
                }
            }
        }
        return c;
    }

    public void solve(char[][] grid, int row, int col){
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length){
            return;
        } 
        if(grid[row][col] == '0' || grid[row][col] == '2'){
            return;
        }

        grid[row][col] = '2';
        solve(grid, row+1, col);
        solve(grid, row-1, col);
        solve(grid, row, col+1);
        solve(grid, row, col-1);
    }
}