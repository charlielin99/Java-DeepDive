class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> result = new ArrayList<>();
        int sL = s.length();
        int pL = p.length();
        
        if (s.length() == 0 || p.length() == 0 || p.length() > s.length()){
            return result;
        }
        
        char[] sWindow = new char[256];
        char[] pWindow = new char[256];
        
        for (int i=0; i<pL; i++){
            sWindow[s.charAt(i)]++;
            pWindow[p.charAt(i)]++;
        }
        
        for (int i=pL; i<sL; i++){
            if (compare(sWindow, pWindow)){
                result.add(i - pL);
            }
            
            sWindow[s.charAt(i)]++;
            
            sWindow[s.charAt(i-pL)]--;
            
        }
        
        if (compare(sWindow, pWindow)){
            result.add(sL - pL);
        }
        
        return result;
    }
    
    public boolean compare(char[] sWindow, char[] pWindow){
        for (int i=0; i<256; i++){
            if (sWindow[i] != pWindow[i]){
                return false;
            }
        }
        return true;
    }
}