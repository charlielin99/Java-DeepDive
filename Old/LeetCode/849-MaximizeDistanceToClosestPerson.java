/*
Idea is simple. Use two pointers.

If the current value is "0", keep going forward.
Left pointer points to the position of left "1" and right pointer points to the position of right "1". Keep updating two pointers and calculate the max distance.
Be careful of two situations: seats[0] is 0 and seats[len - 1] is 0. Just check them and get the final answer. Ex: 00101000.
Time: O(n)
*/
class Solution {
    public int maxDistToClosest(int[] seats) {
        int left = -1, maxDis = 0;
        int len = seats.length;
        
        for (int i = 0; i < len; i++) {
            if (seats[i] == 0) continue;

            if (left == -1) {
                maxDis = Math.max(maxDis, i);
            } else {
                maxDis = Math.max(maxDis, (i - left) / 2);
            }
            left = i;
        }
        
        if (seats[len - 1] == 0) {
            maxDis = Math.max(maxDis, len - 1 - left);
        }
        
        return maxDis;
    }
}