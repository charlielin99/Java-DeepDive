/*
method combine is to add new letters to old list, using 2 for-loop.

for example:

gave digits = "23"

i=0 -> result=combine("abc", [""]) ---> [a,b,c];

i=1 -> result=combine("def", [a,b,c]) ---> [ad,bd,cd, ae,be,ce, af,bf,cf];
*/

 public class Solution {
       public static List<String> letterCombinations(String digits) {
           String digitletter[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
           List<String> result = new ArrayList<String>();
    
           if (digits.length()==0) return result;
            
            result.add("");
            for (int i=0; i<digits.length(); i++) 
                result = combine(digitletter[digits.charAt(i)-'0'],result);
            
            return result;
        }
        
        public static List<String> combine(String digit, List<String> l) {
            List<String> result = new ArrayList<String>();
            
            for (int i=0; i<digit.length(); i++) 
                for (String x : l) 
                    result.add(x+digit.charAt(i));
    
            return result;
        }
}