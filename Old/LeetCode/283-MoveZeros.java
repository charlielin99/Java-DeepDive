class Solution {
    public void moveZeroes(int[] nums) {
        int read = 0;
        int write = 0;
        
        while (read < nums.length){
            if (nums[read] != 0){
                nums[write++] = nums[read];
            }
            read++;
        }
        
        for (int i=write; i<nums.length; i++){
            nums[i] = 0;
        }
    }
}