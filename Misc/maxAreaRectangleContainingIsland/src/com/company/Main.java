package com.company;

public class Main {

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        int[][] grid2 = new int[][] {
                {0,0,0,1,1},
                {0,0,1,1,0},
                {0,0,1,0,0},
                {0,1,1,0,0},
                {1,1,0,0,0}};

        int[][] grid3 = new int[][] {
                {1,1,1,0},
                {1,1,1,0},
                {1,1,1,1}};

        System.out.println(maxAreaOfIsland(grid2));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[i].length; j++){
                if (grid[i][j] == 1){
                    int size = getRectangularArea(grid, i, j,0, j, j, i, i);
                    max = Math.max(size, max);
                }
            }
        }

        return max;
    }

    public static int getRectangularArea(int[][] grid, int i, int j, int area, int leftX, int rightX, int bottomY, int topY){
        if (i < 0 || j < 0 || i >= grid.length || j>= grid[i].length || grid[i][j] == 0){
            return area;
        }

        grid[i][j] = 0;

        if (j < leftX){
            leftX = j;
        } else if (j > rightX){
            rightX = j;
        }

        if (i > bottomY) {
            bottomY = i;
        } else if (i < topY){
            topY = i;
        }

        area = Math.max(area, ((rightX - leftX)+1) * ((bottomY - topY)+1));

        area = getRectangularArea(grid, i+1, j,area, leftX, rightX, bottomY, topY);
        area = getRectangularArea(grid, i-1, j,area, leftX, rightX, bottomY, topY);
        area = getRectangularArea(grid, i, j+1,area, leftX, rightX, bottomY, topY);
        area = getRectangularArea(grid, i, j-1,area, leftX, rightX, bottomY, topY);

        return area;
    }
}
