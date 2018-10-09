//2^n for combination sum II
class Solution {
public List<List<Integer>> combinationSum2(int[] candidates, int target) {
   List<List<Integer>> list = new LinkedList<List<Integer>>();
   Arrays.sort(candidates);
   backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
   return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] cand, int remain, int start) {
   
   if(remain < 0) return; /** no solution */
   else if(remain == 0) list.add(new ArrayList<>(tempList));
   else{
      for (int i = start; i < cand.length; i++) {
         if(i > start && cand[i] == cand[i-1]) continue; /** skip duplicates */
         tempList.add(cand[i]);
         backtrack(list, tempList, cand, remain - cand[i], i+1);
         tempList.remove(tempList.size() - 1); // like stack.pop()
      }
   }
}
}