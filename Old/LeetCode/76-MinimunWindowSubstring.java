public class Solution {
/*
1. create a hashmap for each character in t and count their frequency in t as the value of hashmap.
2. Find the first window in S that contains T. But how? there the author uses the count.
3. Checking from the leftmost index of the window and to see if it belongs to t. The reason we do so is that we want to shrink the size of the window.
3-1) If the character at leftmost index does not belong to t, we can directly remove this leftmost value and update our window(its minLeft and minLen value)
3-2) If the character indeed exists in t, we still remove it, but in the next step, we will increase the right pointer and expect the removed character. If find so, repeat step 3.
*/
public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap();
        for(char c : t.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }
            else{
                map.put(c, 1);
            }
        }
        int left = 0, minLeft=0, minLen =s.length()+1, count = 0;
        for(int right = 0; right<s.length(); right++){
            char r = s.charAt(right);
            if(map.containsKey(r)){//the goal of this part is to get the first window that contains whole t
                map.put(r, map.get(r)-1);
                //identify if the first window is found by counting frequency of the characters of t showing up in S
                if(map.get(r)>=0) count++;
            }
            while(count == t.length()){//if the count is equal to the length of t, then we find such window
                if(right-left+1 < minLen){//jsut update the minleft and minlen value
                    minLeft = left;
                    minLen = right-left+1;
                }
                char l = s.charAt(left);
                if(map.containsKey(l)){
                    //starting from the leftmost index of the window, we want to check if s[left] 
                    //is in t. If so, we will remove it from the window, and increase 1 time on its 
                    //counter in hashmap which means we will expect the same character later by shifting
                    //right index. At the same time, we need to reduce the size of the window due to the removal.
                    map.put(l, map.get(l)+1);
                    if(map.get(l)>0) count--;
                }
                left++;
                //if it doesn't exist in t, it is not supposed to be in the window, left++. 
                //If it does exist in t, the reason is stated as above. left++.
            }
        }
        return minLen==s.length()+1?"":s.substring(minLeft, minLeft+minLen);
    }
}