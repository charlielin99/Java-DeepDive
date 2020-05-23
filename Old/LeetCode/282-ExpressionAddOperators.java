class Solution {
    
    // time O(N * 4^ (N - 1))
    // there are 4 cases:
    // plus, minus, multiply and the next digit
    // dfs
    
    public List<String> addOperators(String num, int target) {
      int v = num.length();
      char[] sc = num.toCharArray();
      char[] path = new char[2 * v];
      List<String> res = new ArrayList();
      long n = 0;
      for(int i = 0; i < v; i++){
        n = n * 10 + (sc[i] - '0');
        path[i] = sc[i];
        helper(res, path, i + 1, sc, i + 1, 0, n, target);
        if(n == 0) break; // deal with '001' case, only `0` in the first loop will be handled.
      }
      return res;
    }
    
    /**
    path for store temporary result path, pathi is the end index
    sc is input char array, sci is end index
    left is what before we do the calculation
    cur is the new number from last recuisive call
    */
    void helper(List<String> res, char[] path, int pathi, char[] sc, int sci, long left, long cur, int target){
      if(sci == sc.length){
        if(left + cur == target){
           res.add(new String(path, 0, pathi));
        }
        return;
      }
      
      long n = 0;
      int signIndex = pathi;
      pathi++;//jump over signIndex
      for(int i = sci; i < sc.length; i++){
        //*put a new numberic char to path*  
        path[pathi] = sc[i];
        pathi++;
        //**************  
        n = n * 10 + (sc[i] - '0');//add a new digit
        path[signIndex] = '+';
        helper(res, path, pathi, sc, i + 1, left + cur, n, target);
        path[signIndex] = '-';
        helper(res, path, pathi, sc, i + 1, left + cur, -n, target);
        path[signIndex] = '*';
        helper(res, path, pathi, sc, i + 1, left, cur * n, target);
        if(n == 0) break; // deal with '001' case, only `0` in the first loop will be handled.
      }
    }
}