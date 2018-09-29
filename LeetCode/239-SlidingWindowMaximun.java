class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        if (k == 0){
            return new int[0];
        }
        
        int[] result = new int [nums.length - k + 1];
        int resultCounter = 0;
        LinkedList<Integer> storage = new LinkedList<>();
        
        for (int i=0; i<k; i++){
            while (!storage.isEmpty() && nums[storage.peekLast()] <= nums[i]){
                storage.removeLast();
            }
            storage.addLast(i);
        }
        
        result[resultCounter++] = nums[storage.peekFirst()];
        
        for (int i=k; i<nums.length; i++){
            if (!storage.isEmpty() && storage.peekFirst() <= i - k){
                storage.removeFirst();
            }
            while (!storage.isEmpty() && nums[storage.peekLast()] <= nums[i]){
                storage.removeLast();
            } 

            storage.addLast(i);
            result[resultCounter++] = nums[storage.peekFirst()];
        }
        
        return result;
    }
        
}