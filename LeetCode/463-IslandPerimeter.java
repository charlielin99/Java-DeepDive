/*
loop over the matrix and count the number of islands;
if the current dot is an island, count if it has any right neighbour or down neighbour;
the result is islands * 4 - neighbours * 2


we check bottom and right only and multiply by 2 because
We are checking bottom and right because we are iterating through the 2 D array and at any '1' we would've already checked all the elements before that element(top or left elements). And we are multiplying by 2 because we are removing the common edges we are already considering as part of the 4 * islands. Hope this helps!

time o(n*m)
space o(1)
*/
public class Solution {
    public int islandPerimeter(int[][] grid) {
        int islands = 0, neighbours = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                }
            }
        }

        return islands * 4 - neighbours * 2;
    }
}