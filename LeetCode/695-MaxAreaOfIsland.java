class Solution {
    // time: o(m*n)
    // space: o(m*n) for bfs
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[i].length; j++){
                if (grid[i][j] == 1){
                    int size = getArea(grid, i, j, 0);
                    max = Math.max(size, max);
                }
            }
        }
        
        return max;
    }
    
    public int getArea(int[][] grid, int i, int j, int size){
        if (i < 0 || j < 0 || i >= grid.length || j>= grid[i].length || grid[i][j] == 0){
            return size;
        }
        
        grid[i][j] = 0;
        size++;
        size = getArea(grid, i+1, j, size);
        size = getArea(grid, i-1, j, size);
        size = getArea(grid, i, j+1, size);
        size = getArea(grid, i, j-1, size);
        
        return size;
    }
}