//DP Solution 

/*
This is a classic back pack problem. 
 -- Define dp[n][k], where dp[i][j] means for house i with color j the minimum cost. 
 -- Initial value: dp[0][j] = costs[0][j]. For others, dp[i][j] = Integer.MAX_VALUE;, i >= 1
 -- Transit function: dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + cost[i][j]), where k != j.
 -- Final state: Min(dp[n - 1][k]).

Time complexity: O(n*k*k).
Space complexity: O(n*k).
*/

 public class Solution {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
         
        int n = costs.length;
        int k = costs[0].length;
         
        // dp[i][j] means the min cost painting for house i, with color j
        int[][] dp = new int[n][k];
         
        // Initialization
        for (int i = 0; i < k; i++) {
            dp[0][i] = costs[0][i];
        }
         
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int m = 0; m < k; m++) {
                    if (m != j) {
                        dp[i][j] = Math.min(dp[i - 1][m] + costs[i][j], dp[i][j]);
                    }
                }
            }
        }
         
        // Final state
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            minCost = Math.min(minCost, dp[n - 1][i]);
        }
         
        return minCost;
    }
}

/*
O(nk) time solution

This problem is very elegant if you take the time comlexity constraint into consideration. 
It actually share the same dynamic programming idea as Paint House |.

If we continue follow the old coding structure, we definitely would end up with the time complexity: O(nk^2).
level 1: n is the total number of houses we have to paint. 
level 2: the first k represent for each house we need to try k colors. 
level 3: the second k was caused by the process to search the minimum cost (if not use certain color).

Apparently, if we want reach the time complexity O(nk), we have to optimize our operation at level 3. 
If we choose the color[i][j], how could we reduce the comparision between (color[i-1][0] to color[i-1][k], except color[i-1][j])
And we know there are acutally extra comparisions, since fore each color, we have to find the smallest amongst other colors. 

There must be way to solve it, Right?
Yup!!! There is a magic skill for it!!!
Let us assume, we have "min_1" and "min_2". 
min_1 : the lowest cost at previous stage.
min_2 : the 2nd lowest cost at previous stage. 

And we have the minimum costs for all colors at previous stage.
color[i-1][k]

Then, iff we decide to paint house "i" with color "j", we can compute the minimum cost of other colors at "i-1" stage through following way.
case 1: iff "color[i-1][j] == min_1", it means the min_1 actually records the minimum value of color[i-1][j] (previous color is j), we have to use min_2;
case 2: iff "color[i-1][j] != min_1", it means min_1 is not the value of color[i-1][j] (previous color is not j), we can use the min_1's color.
Note: iff "pre_min_1 == pre_min_2", it means there are two minimum costs, anyway, no matter which color is pre_min_1, we can use pre_min_2.
----------------------------------------------------------
if (dp[j] != pre_min_1 || pre_min_1 == pre_min_2) {
    dp[j] = pre_min_1 + costs[i][j];
} else{
    dp[j] = pre_min_2 + costs[i][j];
}
----------------------------------------------------------
The way to maintain "min_1" and "min_2".
for (int i = 0; i < len; i++) {
    ...
    min_1 = Integer.MAX_VALUE;
    min_2 = Integer.MAX_VALUE;
    ...
    if (dp[j] <= min_1) {
        min_2 = min_1;
        min_1 = dp[j];
    } else if (dp[j] < min_2){
        min_2 = dp[j];
    }
}

Note:
To reduce the burden of handling case, we absolutely could start from i=0, when we could assume all previous cost is 0 since we have no house.


public class Solution {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
         
        int n = costs.length;
        int k = costs[0].length;
         
        // dp[j] means the min cost for color j
        int[] dp = new int[k];
        int min1 = 0;
        int min2 = 0;
 
        for (int i = 0; i < n; i++) {
            int oldMin1 = min1;
            int oldMin2 = min2;
             
            min1 = Integer.MAX_VALUE;
            min2 = Integer.MAX_VALUE;
             
            for (int j = 0; j < k; j++) {
                if (dp[j] != oldMin1 || oldMin1 == oldMin2) {
                    dp[j] = oldMin1 + costs[i][j];
                } else {
                    dp[j] = oldMin2 + costs[i][j];
                }
                 
                if (min1 <= dp[j]) {
                    min2 = Math.min(min2, dp[j]);
                } else {
                    min2 = min1;
                    min1 = dp[j];
                }
            }
             
        }
         
        return min1;
    }
}

*/