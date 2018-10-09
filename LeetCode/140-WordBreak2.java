//o(n^3) time - recursion tree goes up to n^2 and creation of list is n time
// o(n^3) space - depth of recursion goes up to n and each activation can contain a string list of size n

class Solution {
public List<String> wordBreak(String s, List<String> dict) {
    return backtrack(s,dict,new HashMap<String, List<String>>());
}
// backtrack returns an array including all substrings derived from s.
public List<String> backtrack(String s, List<String> dict, Map<String,List<String>> mem){
    if(mem.containsKey(s)) return mem.get(s);
    List<String> result = new ArrayList<String>();
    for(String word: dict)
        if(s.startsWith(word)) {
            String next = s.substring(word.length());
            if(next.length()==0) result.add(word);
            else for(String sub: backtrack(next, dict, mem)) result.add(word+" "+sub);
        }
    mem.put(s, result);
    return result;
}
}