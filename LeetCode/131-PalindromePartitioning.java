/*The normal dfs backtracking will need to check each substring for palindrome, but a dp array can be used to record the possible break for palindrome before we start recursion.

Edit:
Sharing my thought process:
first, I ask myself that how to check if a string is palindrome or not, usually a two point solution scanning from front and back. Here if you want to get all the possible palindrome partition, first a nested for loop to get every possible partitions for a string, then a scanning for all the partitions. That's a O(n^2) for partition and O(n^2) for the scanning of string, totaling at O(n^4) just for the partition. However, if we use a 2d array to keep track of any string we have scanned so far, with an addition pair, we can determine whether it's palindrome or not by justing looking at that pair, which is this line if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j+1][i-1])). This way, the 2d array dp contains the possible palindrome partition among all.

second, based on the prescanned palindrome partitions saved in dp array, a simple backtrack does the job.

//o(2^n)

*/

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j <= i; j++) {
                if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                }
            }
        }
        helper(res, new ArrayList<>(), dp, s, 0);
        return res;
    }
    
    private void helper(List<List<String>> res, List<String> path, boolean[][] dp, String s, int pos) {
        if(pos == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = pos; i < s.length(); i++) {
            if(dp[pos][i]) {
                path.add(s.substring(pos,i+1));
                helper(res, path, dp, s, i+1);
                path.remove(path.size()-1);
            }
        }
    }
}