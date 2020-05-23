class Solution {
    // Time O(n), space: O(n).
    // No sort, use a hashmap to store indexes 's indices as values, values as indices.
    
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        if (indexes == null || indexes.length == 0) {
            return S;
        }
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < indexes.length; i++) {
            map.put(indexes[i], i);
        }
        sb.append(S);
        for (int i = S.length() - 1; i >= 0; i--) {
            if (map.containsKey(i)) {
                int index = map.get(i);
                if (S.substring(i).startsWith(sources[index])) {
                    sb.replace(i, i + sources[index].length(), targets[index]);
                }
            }
        }
        return sb.toString();
    }
}