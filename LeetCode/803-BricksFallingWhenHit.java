/*
1. Remove all bricks in hits. If the cell is originly 1, we set it to -1 so that we can add the brick back;
2. DFS from the first row (roof), set all cells of bricks to 2 so that we know these cells have been visited.
3. Iterate from the last hit to the first one, i.e., put the erasured bricks back. For every step:
3.1 if the cell is 0, continue;
3.2 else the cell is -1. Check if the cell is attathed to the roof (or any cell with value 2)
If no, continue;
Else, reuse the dfs function to count all the connected bricks (cells with value 1). These are bricks that fell down when we erase the hit! Remember to minus 1, which is the brick we erased.
*/

class Solution {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        if (hits == null || hits.length == 0) return null;
        int[] res = new int[hits.length];
        if (grid == null || grid.length == 0) return res;
        int m = grid.length, n = grid[0].length;
        if (n == 0) return res;
        
        for (int k = 0; k < hits.length; k++){
            int x = hits[k][0], y = hits[k][1];
            if (grid[x][y] == 1) grid[x][y] = -1;
        }
        // set all cells attached to the roof to 2
        int count = countBricks(grid);
        
        for (int k = hits.length-1; k >= 0; k--){
            int x = hits[k][0], y = hits[k][1];
            if (grid[x][y] == 0) res[k] = 0;
            else {
                grid[x][y] = 1;
                if (!attachedToRoof(grid, x, y)) continue;
                res[k] = dfs(grid, x, y) - 1;
            }
        }
        return res;
    }
    
    public int countBricks(int[][] grid){
        int m = grid.length, n = grid[0].length;
        int count = 0;
        for (int j = 0; j < n; j++){
            count += dfs(grid, 0, j);
        }
        return count;
    }

    // count all cells starting from (i, j)
    public int dfs(int[][] grid, int i, int j){
        if (grid[i][j] != 1) return 0;
        int m = grid.length, n = grid[0].length;
        int count = 1;
        grid[i][j] = 2;
        int[] shift = new int[]{-1, 0, 1, 0, -1};
        for (int k = 0; k < 4; k++){
            int p = i + shift[k];
            int q = j + shift[k+1];
            if (p < 0 || p >= m || q < 0 || q >= n) continue;
            if (grid[p][q] != 1) continue;
            count += dfs(grid, p, q);
        }
        return count;
    }
    
    public boolean attachedToRoof(int[][] grid, int i, int j){
        if (i == 0) return true;
        int m = grid.length, n = grid[0].length;
        int[] shift = new int[]{-1, 0, 1, 0, -1};
        for (int k = 0; k < 4; k++){
            int p = i + shift[k];
            int q = j + shift[k+1];
            if (p < 0 || p >= m || q < 0 || q >= n) continue;
            if (grid[p][q] == 2) return true;
        }
        return false;
    }
}