class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length () == 0){
            return s;
        }
        
        int left = 0;
        int right = s.length() - 1;
        char[] arr = s.toCharArray();
        
        while (left < right){
            while (left < right && !isVowel(arr[left])) {
                left++;
            }
            while (left < right && !isVowel(arr[right])) {
                right--;
            }
            
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            
            left++;
            right--;
        }
        
        return new String(arr);
    }
    
    public boolean isVowel(char c){
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        
        return set.contains(c);
        
    }
}