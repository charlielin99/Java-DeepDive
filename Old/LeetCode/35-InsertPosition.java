class Solution {
    public int searchInsert(int[] nums, int target) {
        int lower = -1;
        int upper = nums.length;
        
        while (lower+1 != upper){
            int seek = lower + ((upper - lower) / 2);
            if (nums[seek] == target){
                return seek;
            } else if (nums[seek] < target){
                lower = seek;
            } else if (nums[seek] > target){
                upper = seek;
            }  
        }
        
        return upper;
    }
}