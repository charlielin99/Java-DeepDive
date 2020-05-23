class Solution {
    /*
    Solution 1. Brute force. We just need two loops (i, j) and test if SUM[i, j] = k. Time complexity O(n^2), Space complexity          O(1). I bet this solution will TLE.
    
    Solution 2. From solution 1, we know the key to solve this problem is SUM[i, j]. 
    So if we know SUM[0, i - 1] and SUM[0, j], then we can easily get SUM[i, j]. 
    To achieve this, we just need to go through the array, calculate the current sum 
    and save number of all seen PreSum to a HashMap. 
    Time complexity O(n), Space complexity O(n).
    */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);   //key: preSum, value: frequency
        int count = 0;
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (preSum.containsKey(curSum - k)) count += preSum.get(curSum - k);
            // it means there is some sum value v between 0 and x, which makes sum of array [x + 1 to i] == k
            // the frequency is the number of x
            preSum.put(curSum, preSum.getOrDefault(curSum, 0) + 1);
        }
        return count;
    }
}