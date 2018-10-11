class Solution {
    
    /*
    Remember how we do multiplication?
    Start from right to left, perform multiplication on every pair of digits, 
    and add them together. Let's draw the process! From the following draft, 
    we can immediately conclude:

    `num1[i] * num2[j]` will be placed at indices `[i + j`, `i + j + 1]` 
    */
    
    // the product of ith and jth number will be stroed in position i+j and i+j+1,
    // i.e., pos[i+j] is used to store the carry value and pos[i+j+1] is used to rightmost digit of the sum.
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];
   
        //use [i+j,i+j+1] to store num1[i]*num[j]
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }  
    
        StringBuilder sb = new StringBuilder();
        // Just to check if first number is zero , you also can use another way.
        // !(sb.length() == 0 && p == 0)
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}