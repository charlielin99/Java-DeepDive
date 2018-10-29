class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        // this solution use memoization so all cells are only visited once
        // time: O(n*m)
        // space o(n*m)
        if (matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
        int m=matrix.length, n=matrix[0].length, res=0;
        int[][] memo= new int[m][n];
        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++)
                res=Math.max(res, dfs(matrix, i, j, memo, -1));
        return res;
    }
    public int dfs(int[][] matrix, int i, int j, int[][] memo, int cur){
        int m=matrix.length, n=matrix[0].length, res=0;
        if (i<0 || i>=m || j<0 || j>=n || matrix[i][j]<=cur) return 0;
        if (memo[i][j]!=0) return memo[i][j];
        res=Math.max(res, dfs(matrix, i+1, j, memo, matrix[i][j]));
        res=Math.max(res, dfs(matrix, i-1, j, memo, matrix[i][j]));
        res=Math.max(res, dfs(matrix, i, j+1, memo, matrix[i][j]));
        res=Math.max(res, dfs(matrix, i, j-1, memo, matrix[i][j]));
        res++;
        memo[i][j]=res;
        return res;
    }
}