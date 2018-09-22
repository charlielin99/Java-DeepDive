class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0){
            return new ArrayList<List<String>>();
        }
        
        Map<String, List<String>> map = new HashMap<>();
        for (String s: strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String myKey = String.valueOf(arr);
            if (!map.containsKey(myKey)){
                map.put(myKey, new ArrayList<>());
            }
            map.get(myKey).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}