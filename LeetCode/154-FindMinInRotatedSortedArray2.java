class Solution {
    //There is no faster way than O(n) to solve an input like "1 1 1 1 1 0 1 1 1 1 1 1 1 1". 
    //Binary search won't work in this case as your nums[start] == nums[mid] == nums[end], 
    //which half would you discard then? In other words, you have to examine all elements. 
    public int findMin(int[] nums) {
        int min = nums[0];
        for (int val: nums){
            if (min > val){
                min = val;
            }
        }
        
        return min;
    }
}