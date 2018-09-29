public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
    	if (nums.length() == 0 || nums == null){
    		return nums;
    	}
    	if (nums.length() == 1){
    		nums[0] = calculate(nums[0], a, b, c);
    		return nums;
     	}

     	int l = 0;
     	int r = nums.length - 1;
     	int k = 0;
     	int[] result = new int[nums.length];

     	while (l <= r){
     		int v1 = calculate(nums[l], a, b, c);
     		int v2 = calculate(nums[r], a, b, c);

     		if (a > 0){
     			result[k++] = v1 > v2 ? v1 : v2;
     			if (v1 > v2){
     				l++;
     			} else {
     				r--;
     			}
     		} else {
     			result[k++] = v1 > v2 ? v2 : v1;
     			if (v1 > v2){
     				r--;
     			} else {
     				l++;
     			}
     		}
     	}

     	if (a > 0){
     		int left = 0;
     		int right = result.length - 1;
     		while (left < right){
     			int temp = result[left];
     			result[left] = result[right];
     			result[right] = temp;
     			left++;
     			right--;
     		}
     	}

     	return result;
	}

	public int calculate(int x, int a, int b, int c){
		int result = a * (x * x) + b*x + c;
		return result;
	}
}