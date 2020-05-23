public class Solution {
    
    /*I used a dp array of size n + 1 to save subproblem solutions. 
      dp[0] means an empty string will have one way to decode,  dp[1]     
      means the way to decode a string of size 1. I then check one digit 
      and two digit combination and save the results along the way. 
      In the end, dp[n] will be the end result.
    */
    
    //time: o(n)
    //space: o(n)
    
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            if(first >= 1 && first <= 9) {
               dp[i] += dp[i-1];  
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}

//PRINT OUT SET OF DECODINGS
/*
i kept them in sets saving all of the combinations for each subproblem and each time i append each of the previous combinations in decodings[i - 1] or decodings[i - 2] with the new string pieces


public static Set<String> allDecodings(String s) {
        if (s == null || s.length() == 0) {
            return new HashSet<>();
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        Set<String>[] decodings = new Set[n + 1];

        dp[0] = 1;
        decodings[0] = new HashSet<>();
        decodings[0].add("");

        decodings[1] = new HashSet<>();
        if (s.charAt(0) == '0') {
            dp[1] = 0;
        } else {
            dp[1] = 1;
            decodings[1].add(Character.toString((char)(Integer.valueOf(s.substring(0, 1)) + 'A' - 1)));
        }

        for (int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            decodings[i] = new HashSet<>();

            if (first >= 1 && first <= 9) {
                dp[i] += dp[i - 1];
                for (String decoding: decodings[i - 1]) {
                    decodings[i].add(decoding + Character.toString((char)(first + 'A' - 1)));
                }
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
                for (String decoding: decodings[i - 2]) {
                    decodings[i].add(decoding + Character.toString((char)(second + 'A' - 1)));
                }
            }
        }

        return decodings[n];
    }
*/