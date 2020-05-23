class Solution {
    /*
    Problem
    "Start from any index, we can collect at most two types of fruits. What is the maximum amount"

    Translation
    Find out the longest length of subarrays with at most 2 different numbers?

    Complexity:O(N) time, O(1) space
    */
    public int totalFruit(int[] tree) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        int res = 0, i = 0;
        for (int j = 0; j < tree.length; ++j) {
            count.put(tree[j], count.getOrDefault(tree[j], 0) + 1);
            while (count.size() > 2) {
                count.put(tree[i], count.get(tree[i]) - 1);
                if (count.get(tree[i]) == 0) count.remove(tree[i]);
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}