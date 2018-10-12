public class Solution {
    // time o(n)
    // space o(n)
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();

        while(n>0){
            //How to figure out that n-- is needed at the beginning of the loop?
            //I think the reason we do n-- is that number 0 is not included in this sheet. We can consider this 
            //transformation as base-26. However, classic base-26 consists of number from 0 to 25, and in this 
            //case we have numbers from 1 to 26. Now n-- seems intuitive and reasonable.
            n--;
            result.insert(0, (char)('A' + n % 26));
            n /= 26;
        }

        return result.toString();
    }
}


/*
Insert a char at the beginning is not very efficient. The complexity will be n^2. We can append the character to the end and reverse the string in the end, and the complexity will be linear.

public class Solution {
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            n--;
            result.append((char)('A' + n % 26));
            n /= 26;
        }
        result.reverse();
        return result.toString();
    }
}
*/