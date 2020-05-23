//2^n for combination sum II
class Solution {
public List<List<Integer>> combinationSum2(int[] candidates, int target) {
   List<List<Integer>> list = new LinkedList<List<Integer>>();
    // Sorting is to make sure that each output list is sorted to avoid 
    // the repeated combinations in the form like [1 2 3], [3 2 1]
   Arrays.sort(candidates);
   backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
   return list;
}
    
/*
Here is the order that the elements get added to the list
[]
[1]
[1,2]
[1,2,3]
[1,3]
[2]
[2,3]
[3]
It is important to visual this order for easy understanding of the code.
*/

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] cand, int remain, int start) {
   
   if(remain < 0) return; /** no solution */
   else if(remain == 0) list.add(new ArrayList<>(tempList));
   else{
      for (int i = start; i < cand.length; i++) {
         if(i > start && cand[i] == cand[i-1]) continue; /** skip duplicates */
         tempList.add(cand[i]);
         backtrack(list, tempList, cand, remain - cand[i], i+1);
         tempList.remove(tempList.size() - 1); // like stack.pop()
         /*
         tempList is a temporary list to hold the values while we traverse the recursion tree path. 
         As we backtrack, we remove the last inserted value so that we can reuse the tempList 
         for the next recursion call. At any node in the recursion tree, 
         tempList "remembers" the path up to that node.
         */
      }
   }
}
}