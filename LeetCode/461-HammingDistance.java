class Solution {
    
    //The problem is basically the same as counting the 1 bits in an integer
    //and the useful trick to do that is : xor & (xor - 1) will eliminate the last 1 bit in a integer.

    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        
        while (xor != 0) {
            xor &= (xor - 1);
            count++;
        }
        return count;
    }
}