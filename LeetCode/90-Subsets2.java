public class Solution {
    //o(2^n) time
    //o(n) space
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        subsetsWithDupHelper(nums, 0, res, new ArrayList<>());
        return res;
    }
    
    private void subsetsWithDupHelper(int[] nums, int pos, List<List<Integer>> res, List<Integer> tmpRes) {
        // subset means it does not need contain all elements, so the condition is <= rather than ==
        // and do not return after this statement
        if(pos <= nums.length) res.add(new ArrayList<>(tmpRes));
        
        for(int i=pos; i<nums.length; i++) {
            if(i > pos && nums[i] == nums[i-1]) continue;   // avoid duplicates
            tmpRes.add(nums[i]);
            subsetsWithDupHelper(nums, i + 1, res, tmpRes);
            tmpRes.remove(tmpRes.size() - 1);
            /*
         tempList is a temporary list to hold the values while we traverse the recursion tree path. 
         As we backtrack, we remove the last inserted value so that we can reuse the tempList 
         for the next recursion call. At any node in the recursion tree, 
         tempList "remembers" the path up to that node.
         */
        }
    }
}