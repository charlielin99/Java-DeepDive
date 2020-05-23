class Solution {
    public boolean isAnagram(String s, String t) {
        int[] dict = new int[26];
        for (int i=0; i<s.length(); i++){
            dict[s.charAt(i) - 'a']++;
        }
        for (int i=0; i<t.length(); i++){
            dict[t.charAt(i) - 'a']--;
        }
        
        for (Integer i: dict){
            if (i != 0){
                return false;
            }
        }
        
        return true;
        
    }
}