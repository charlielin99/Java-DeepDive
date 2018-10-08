public class Solution {
public int jump(int[] nums) {
    // If nums.length < 2, means that we do not
    // need to move at all.
    if (nums == null || nums.length < 2) {
        return 0;
    }

    // First set up current region, which is
    // from 0 to nums[0].
    int l = 0;
    int r = nums[0];
    // Since the length of nums is greater than
    // 1, we need at least 1 step.
    int step = 1;

    // We go through all elements in the region.
    while (l <= r) {

        // If the right of current region is greater
        // than nums.length - 1, that means we are done.
        if (r >= nums.length - 1) {
            return step;
        }

        // We should know how far can we reach in current
        // region.
        int max = Integer.MIN_VALUE;
        for (; l <= r; l++) {
            max = Math.max(max, l + nums[l]);
        }

        // If we can reach far more in this round, we update
        // the boundary of current region, and also add a step.
        if (max > r) {
            l = r;
            r = max;
            step++;
        }
    }

    // We can not finish the job.
    return -1;
}
}