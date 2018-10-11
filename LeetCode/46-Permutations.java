class Solution {
    //time: o(n!)
    /*
    Choose
    Explore
    unchoose
    */
    
public List<List<Integer>> permute(int[] nums) {
   List<List<Integer>> list = new ArrayList<>();
   backtrack(list, new ArrayList<>(), nums);
   return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
   if(tempList.size() == nums.length){
      list.add(new ArrayList<>(tempList));
   } else{
      for(int i = 0; i < nums.length; i++){ 
         if(tempList.contains(nums[i])) continue; // element already exists, skip
         tempList.add(nums[i]);
         backtrack(list, tempList, nums);
         tempList.remove(tempList.size() - 1);
         /*
         To generate all possible permutations, we need to remove the least recently added 
         element while we are going up the recursive call stack.
         In the first iteration of the for loop we add all permutations, 
         that start with nums[0]. Then, before we can begin building all permutations 
         starting with nums[1], we need to clear the tempList 
         (which currently contains permutations from the first iteration of the for loop) - 
         that's exactly what tempList.remove(tempList.size() - 1) line does.
         */
      }
   }
} 
}