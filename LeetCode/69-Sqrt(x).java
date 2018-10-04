class Solution {
    public int mySqrt(int x) {
        if (x <= 1) return x;
        int lo = 1, hi = x;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (mid <= x/mid) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
}