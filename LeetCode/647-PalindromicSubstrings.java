class Solution {
    /*
    We can reduce the runtime of this algorithm to O(n2) by using the following approach.

For each letter in the input string, start expanding to left and right while checking for even and odd length palindromes. Move to the next letter if we know a palindrome doesn't exist.

We expand one character to the left and right and compare them. If both of them are equal, we print out the palindrome substring.

time o(n^2)
space o(1)
    */
int count =1;
public int countSubstrings(String s) {
    if(s.length()==0) 
        return 0;
    for(int i=0; i<s.length()-1; i++){
        checkPalindrome(s,i,i);     //To check the palindrome of odd length palindromic sub-string
        checkPalindrome(s,i,i+1);   //To check the palindrome of even length palindromic sub-string
    }
    return count;
}    

private void checkPalindrome(String s, int i, int j) {
    while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){    //Check for the palindrome string 
        count++;    //Increment the count if palindromin substring found
        i--;    //To trace string in left direction
        j++;    //To trace string in right direction
    }
}
}