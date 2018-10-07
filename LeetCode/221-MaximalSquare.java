/*It's actually to keep recording the max n*n window at each cell of the matrix.
At each cell, we define that the dynamic programming status at that cell is - if I am the most right-bottom guy of a square, how big the square I can build. With this definition, this status will be transferrable to the guys, right, below, and right below me.
*/

 public class Solution {
        public int maximalSquare(char[][] matrix) {
            
            //illegal check - no square can be formed
            if(matrix == null || matrix.length == 0) return 0;
            
            int result = 0;
            int[][] count = new int[matrix.length][matrix[0].length];
            
            //initialize first row and first column
            for(int i = 0; i < matrix.length; i ++) {
                count[i][0] = matrix[i][0] == '0' ? 0 : 1;
                result = Math.max(result, count[i][0]);
            }
            
            for(int i = 0; i < matrix[0].length; i ++) {
                count[0][i] = matrix[0][i] == '0' ? 0 : 1;
                result = Math.max(result, count[0][i]);
            }
            
            //start to transfer status to iterate each cell from (1, 1) to (m, n)
            //if i am a 0, the square stops, reset
            for(int i = 1; i < matrix.length; i++) {
                for(int j = 1; j < matrix[0].length; j++) {
                    
                    //I break the square reset myself to zero
                    if(matrix[i][j] == '0') {
                        count[i][j] = 0;
                        continue;
                    }
                    
                    //if I am 1, it depends if I can grow the size of the square, if I have a 0 guy around me, 
                    //I can only be a top left guy
                    if(count[i - 1][j - 1] == 0 || count[i - 1][j] == 0 || count[i][j - 1] == 0) {
                        count[i][j] = 1;
                    }
                    //if guys around are the same size, I can be the right-bottom guy of a bigger square
                    else if(count[i - 1][j - 1] == count[i - 1][j] && count[i - 1][j] == count[i][j - 1]) {
                        count[i][j] = count[i - 1][j - 1] + 1;
                    }
                    //guys around me not the same, I can only be the right-bottom guy of a least square
                    else {
                        count[i][j] = Math.min(Math.min(count[i - 1][j - 1], count[i - 1][j]), 
                                                                              count[i][j - 1]) + 1;
                    }
                    result = Math.max(result, count[i][j]);
                }
            }
            return result * result;
        }
}