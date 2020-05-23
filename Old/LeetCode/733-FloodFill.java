class Solution {
    //time o(n*m)
    //space o(n*m)
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] != newColor){
            dfs(image, sr, sc, image[sr][sc], newColor);
        }
        return image;
    }
    
    public void dfs(int[][] image, int x, int y, int color, int newColor){
        if (x < 0 || y < 0 || x >= image.length || y >= image[0].length || image[x][y] != color){
            return;
        }
        
        image[x][y] = newColor;
        dfs(image, x-1, y, color, newColor);
        dfs(image, x+1, y, color, newColor);
        dfs(image, x, y-1, color, newColor);
        dfs(image, x, y+1, color, newColor);
    }
}