class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> myMap = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            int pair = target - nums[i];
            if (myMap.containsKey(pair)){
                return new int[] {myMap.get(pair), i};
            }
            myMap.put(nums[i], i);
        }
        
        throw new IllegalArgumentException("No two integers sum to target!");
    }
}