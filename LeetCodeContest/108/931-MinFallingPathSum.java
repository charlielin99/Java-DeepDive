/*
931. Minimum Falling Path Sum
Given a square array of integers A, we want the minimum sum of a falling path through A.

A falling path starts at any element in the first row, and chooses one element from each row.  The next row's choice must be in a column that is different from the previous row's column by at most one.

 

Example 1:

Input: [[1,2,3],[4,5,6],[7,8,9]]
Output: 12
Explanation: 
The possible falling paths are:
[1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
[2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
[3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
The falling path with the smallest sum is [1,4,7], so the answer is 12.

 

Note:

1 <= A.length == A[0].length <= 100
-100 <= A[i][j] <= 100
*/

// time: must go through all elements o(n^2)
// space: need to create an additional cost matrix o(n^2)
class Solution {
    public int minFallingPathSum(int[][] n) {
        
        int[][] c = new int[n.length][n[0].length];

        // copy over first row because problem can only go downwards

        for (int i=0; i<n.length; i++){
            c[0][i] = n[0][i];
        }
        
        for (int i=1; i<n.length; i++){
            for (int j=0; j<n[0].length; j++){

                //out of bounds checking
                int x = Integer.MAX_VALUE;
                int y = Integer.MAX_VALUE;
                int z = Integer.MAX_VALUE;

                if (j-1 >= 0){
                    x = c[i-1][j-1];
                }
                if (j+1 < n[0].length){
                    z = c[i-1][j+1];
                }
                y = c[i-1][j];


                c[i][j] = n[i][j] + Math.min(Math.min(x,y),z);
            }
        }

        int min = Integer.MAX_VALUE;
        
        for (int i=0; i<c[c.length-1].length; i++){
            min = Math.min(min, c[c.length-1][i]);
        }

        return min;
    }
}