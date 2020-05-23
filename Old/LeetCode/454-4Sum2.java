class Solution {
    // time o(n^2)
    // space o(n) hashmap
public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
	Map<Integer,Integer> sums = new HashMap<>();
	int count = 0;
	for(int i=0; i<A.length;i++) {
		for(int j=0;j<B.length;j++){
			int sum = A[i]+B[j];
			if(sums.containsKey(sum)) {
				sums.put(sum, sums.get(sum)+1);
			} else {
				sums.put(sum, 1);
			}
		}
	}
	for(int k=0; k<A.length;k++) {
		for(int z=0;z<C.length;z++){
			int sum = -(C[k]+D[z]);
			if(sums.containsKey(sum)) {
				count+=sums.get(sum);
			}
		}
	}
	return count;
}
    /*
Take the arrays A and B, and compute all the possible sums of two elements. Put the sum in the Hash map, and increase the hash map value if more than 1 pair sums to the same value.

Compute all the possible sums of the arrays C and D. If the hash map contains the opposite value of the current sum, increase the count of four elements sum to 0 by the counter in the map.
*/
}