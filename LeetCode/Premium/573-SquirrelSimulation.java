/*
Time complexity : O(n). We need to traverse over the whole nutsnuts array once. n refers to the size of nuts array.

Space complexity : O(1). Constant space is used.

https://leetcode.com/articles/squirrel-simulation/
*/

public class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int tot_dist = 0, d = Integer.MIN_VALUE;
        for (int[] nut: nuts) {
            tot_dist += (distance(nut, tree) * 2);
            d = Math.max(d, distance(nut, tree) - distance(nut, squirrel));
        }
        return tot_dist - d;
    }
    public int distance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
