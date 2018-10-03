class Solution {
   public void wiggleSort(int[] nums) {
       
        // After you get median element, the 'nums' is partially sorted such that the first half is 
        // larger or equal to the median, the second half is smaller or equal to the median
        int median = findKthLargest(nums, (nums.length + 1) / 2);
        int n = nums.length;

        int left = 0, i = 0, right = n - 1;
       
       /*
       (1) elements smaller than the 'median' are put into the last even slots
       (2) elements larger than the 'median' are put into the first odd slots
       (3) the medians are put into the remaining slots.
       */
       
       // The index mapping, (1 + 2*index) % (n | 1) will do the job

        while (i <= right) {

            if (nums[newIndex(i,n)] > median) {
                swap(nums, newIndex(left++,n), newIndex(i++,n));
            }
            else if (nums[newIndex(i,n)] < median) {
                swap(nums, newIndex(right--,n), newIndex(i,n));
            }
            else {
                i++;
            }
        }
    }

    public int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }
    
    public void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    
    public int findKthLargest(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;
        int index = nums.length - k;
        
        while (start < end){
            int pivot = partition(nums, start, end);
            if (pivot < index){
                start = pivot + 1;
            } else if (pivot > index){
                end = pivot - 1;
            } else {
                return nums[pivot];
            }
        }
        
        return nums[start];
    }
    
    public int partition(int[] nums, int start, int end){
        int pivot = start;
        int temp;
        
        while (start <= end){
            while (start <= end && nums[start] <= nums[pivot]){
                start++;
            }
            while (start <= end && nums[end] > nums[pivot]) {
                end--;
            }
            if (start > end){
                break;   
            }
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
        
        temp = nums[end];
        nums[end] = nums[pivot];
        nums[pivot] = temp;
        return end;
    }
}