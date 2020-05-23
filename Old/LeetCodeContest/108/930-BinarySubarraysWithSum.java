/*
930. Binary Subarrays With Sum

In an array A of 0s and 1s, how many non-empty subarrays have sum S?

Example 1:

Input: A = [1,0,1,0,1], S = 2
Output: 4
Explanation: 
The 4 subarrays are bolded below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
 

Note:

A.length <= 30000
0 <= S <= A.length
A[i] is either 0 or 1.
*/

class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        Map<Integer, Integer> c = new HashMap<>();
        c.put(0, 1);
        int psum = 0, res = 0;
        for (int i : A) {
            psum += i;
            res += c.getOrDefault(psum - S, 0);
            c.put(psum, c.getOrDefault(psum, 0)+1);
        }
        return res;
    }
}