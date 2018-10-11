class Solution {
    //time o(n+m)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m - 1, tail2 = n - 1, finished = m + n - 1;
        
        while (tail1 >= 0 && tail2 >= 0) {
            if (nums1[tail1] > nums2[tail2]){
                nums1[finished] = nums1[tail1--];
            } else {
                nums1[finished] = nums2[tail2--];
            }
            finished--;
        }

        while (tail2 >= 0) { //only need to combine with remaining nums2
            nums1[finished--] = nums2[tail2--];
        }
    }
}