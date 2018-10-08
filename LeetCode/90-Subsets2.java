class Solution {
public List<List<Integer>> subsetsWithDup(int[] num) {
    Arrays.sort(num);
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    int len = num.length;
    if (len == 0) return ans; 
    
    ans.add(new ArrayList<Integer>()); // first, need to add the subset of num[0]
    ans.add(new ArrayList<Integer>());
    ans.get(1).add(num[0]);
    
    int nprev = 1; // this is the number of lists that the previous number was added in.
                 // if the current number is same as the prev one, it'll be only added in the 
                // lists that has the prev number.
                
    for (int i = 1; i < len ; ++i){
        int size = ans.size();
        if (num[i]!=num[i-1])   // if different
            nprev = size;        // this means add num[i] to all lists in ans;
        for (int j = size-nprev; j < size; ++j){
            List<Integer> l = new ArrayList<Integer>(ans.get(j));
            l.add(num[i]);
            ans.add(l);
        }
    }
    return ans;
}
}