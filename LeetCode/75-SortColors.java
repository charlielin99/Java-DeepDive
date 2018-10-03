class Solution {
    
    /*
    quicksort 3-way partition
    +------+---------+-------------+-------+
    |  <p  |  =p     |  unseen .  |   > p  |
    +------+---------+------------+-------+
            ↑          ↑           ↑
          pivot      first        last
    pivot: 1st elem == pivot
    unseenFirst:  1st unseen elem
    unseenLast: last unseen elem
    */
    
    public void sortColors(int[] nums) {
        int pivot = 0;
        int unseenFirst = 0;
        int unseenLast = nums.length - 1;
        
        while (unseenFirst <= unseenLast) {
            if (nums[unseenFirst] == 0) {
                swap(nums, pivot++, unseenFirst++);
            } else if (nums[unseenFirst] == 2) {
                swap(nums, unseenFirst, unseenLast--);
            } else { // nums[unseenFirst] == 1
                unseenFirst++;
            }
        }
    }
    public void swap(int[] nums, int p1, int p2) {
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }
}