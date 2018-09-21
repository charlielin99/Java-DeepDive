class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[i].length; j++){
                if (grid[i][j] == '1'){
                    count++;
                    sinkSurroundIslands(grid, i, j);
                }
            }
        }
        
        return count;
    }
    
    public void sinkSurroundIslands(char[][] grid, int i, int j){
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != '1'){
            return;
        }
        
        grid[i][j] = '0';
        sinkSurroundIslands(grid, i+1, j);
        sinkSurroundIslands(grid, i-1, j);
        sinkSurroundIslands(grid, i, j+1);
        sinkSurroundIslands(grid, i, j-1);
    }
}