/*
As even when k = 2, the problem is a "Subset Sum" problem which is known to be NP-hard, (and because the given input limits are low,) our solution will focus on exhaustive search.

A natural approach is to simulate the k groups (disjoint subsets of nums). For each number in nums, we'll check whether putting it in the i-th group solves the problem. We can check those possibilities by recursively searching.

Intuition and Algorithm

As in Approach #1, we investigate methods of exhaustive search, and find target = sum(nums) / k in the same way.

Let used have the i-th bit set if and only if nums[i] has already been used. Our goal is to use nums in some order so that placing them into groups in that order will be valid. search(used, ...) will answer the question: can we partition unused elements of nums[i] appropriately?

This will depend on todo, the sum of the remaining unused elements, not crossing multiples of target within one number. If for example our target is 10, and our elements to be placed in order are [6, 5, 5, 4], this would not work as 6 + 5 "crosses" 10 prematurely.

If we could choose the order, then after placing 5, our unused elements are [4, 5, 6]. Using 6 would make todo go from 15 to 9, which crosses 10 - something unwanted. However, we could use 5 since todo goes from 15 to 10; then later we could use 4 and 6 as those placements do not cross.

It turns out the maximum value that can be chosen so as to not cross a multiple of target, is targ = (todo - 1) % target + 1. This is essentially todo % target, plus target if that would be zero.

Now for each unused number that doesn't cross, we'll search on that state, and we'll return true if any of those searches are true.

Notice that the state todo depends only on the state used, so when memoizing our search, we only need to make lookups by used.

In the solutions below, we present both a top-down dynamic programming solution, and a bottom-up one. The bottom-up solution uses a different notion of state.

Time Complexity: O(N * 2^N) where NN is the length of nums. There are 2^N states of used (or state in our bottom-up variant), and each state performs O(N) work searching through nums.

Space Complexity: O(2^N) the space used by memo (or dp, total in our bottom-up variant).
*/

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int N = nums.length;
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        int target = sum / k;
        if (sum % k > 0 || nums[N - 1] > target) return false;

        boolean[] dp = new boolean[1 << N];
        dp[0] = true;
        int[] total = new int[1 << N];

        for (int state = 0; state < (1 << N); state++) {
            if (!dp[state]) continue;
            for (int i = 0; i < N; i++) {
                int future = state | (1 << i);
                if (state != future && !dp[future]) {
                    if (nums[i] <= target - (total[state] % target)) {
                        dp[future] = true;
                        total[future] = total[state] + nums[i];
                    } else {
                        break;
                    }
                }
            }
        }
        return dp[(1 << N) - 1];
    }
}

