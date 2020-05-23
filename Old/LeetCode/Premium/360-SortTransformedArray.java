/*
We know that the transformation function forms a parabola, 
which has a minimum/maximum in the middle, if a != 0, or a line, if a == 0. 
So we can start from two ends, for a > 0, fill the result array from end to start, 
for a < 0, fill the result array from start to end.

Time O(n)
*/

public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums.length == 0) {
            return nums;
        }
        int len = nums.length;
        int[] rst = new int[len];
        int pos1 = 0, pos2 = len - 1;
        int start = 0, end = len - 1;
        while (start <= end) {
            int first = calculate(nums[start], a, b, c);
            int second = calculate(nums[end], a, b, c);
            if (a >= 0) {
                if (first > second) {
                    rst[pos2--] = first;
                    start++;
                } else {
                    rst[pos2--] = second;
                    end--;
                }
            } else {
                if (first < second) {
                    rst[pos1++] = first;
                    start++;
                } else {
                    rst[pos1++] = second;
                    end--;
                }
            }
        }
        return rst;
    }
 
    private int calculate(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }