public class Solution {
    /*
    the run time complexity is O(1).
    In the worst case scenario, when a number is greater than one billion, for example, the function helper is called a constant        number of times. If you derive the recursion tree of this function, you'll see that the longest path in this situation          (number      greater than one billion) is: helper(num > 10^9) is the first to be called, then helper(10^6 < num < 10^9) is          called (from the else statement), then helper(10^3 < num < 10^6), then helper(10^2 < num < 10^3), then helper(20 < num <        10^2), and finally, helper(num < 20), when returns a string.

    Space complexity is o(1), constant arrays
    */
    private final String[] belowTen = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final String[] belowTwenty = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] belowHundred = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return helper(num); 
    }
    
    private String helper(int num) {
        String result = new String();
        if (num < 10) result = belowTen[num];
        else if (num < 20) result = belowTwenty[num -10];
        else if (num < 100) result = belowHundred[num/10] + " " + helper(num % 10);
        else if (num < 1000) result = helper(num/100) + " Hundred " +  helper(num % 100);
        else if (num < 1000000) result = helper(num/1000) + " Thousand " +  helper(num % 1000);
        else if (num < 1000000000) result = helper(num/1000000) + " Million " +  helper(num % 1000000);
        else result = helper(num/1000000000) + " Billion " + helper(num % 1000000000);
        return result.trim();
    }
}