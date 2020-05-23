class Solution {
/*
Basic idea is to reduce the 4Sum problem to 2Sum one. In order to achieve that, we can use an array (size of n^2) to store the pair sums and this array will act as the array in 2Sum case (Here n is the size of the original 1D array and it turned out that we do not even need to explicitly use the n^2 sized array ). We also use a hashmap to mark if a pair sum has been visited or not (the same as in the 2Sum case). The tricky part here is that we may have multiple pairs that result in the same pair sum. So we will use a list to group these pairs together. For every pair with a particular sum, check if the pair sum that is needed to get the target has been visited. If so, further check if there is overlapping between these two pairs. If not, record the result.

Time complexity to get all the pairs is O(n^2). For each pair, if the pair sum needed to get the target has been visited, the time complexity will be O(k), where k is the maximum size of the lists holding pairs with visited pair sum. Therefore the total time complexity will be O(k*n^2). Now we need to determine the range of k. Basically the more distinct pair sums we get, the smaller k will be. If all the pair sums are different from each other, k will just be 1. However, if we have many repeated elements in the original 1D array, or in some extreme cases such as the elements form an arithmetic progression, k can be of the order of n (strictly speaking, for the repeated elements case, k can go as high as n^2, but we can get rid of many of them). On average k will be some constant between 1 and n for normal elements distribution in the original 1D array. So on average our algorithm will go in O(n^2) but with worst case of O(n^3). Here is the complete code in java:
*/

public List<List<Integer>> fourSum(int[] num, int target) {
    Arrays.sort(num);
    
    Map<Integer, List<int[]>> twoSumMap = new HashMap<>(); // for holding visited pair sums. All pairs with the same pair sum are grouped together
    Set<List<Integer>> res = new HashSet<>();  // for holding the results
    
    for (int i = 0; i < num.length; i++) {
    	// get rid of repeated pair sums
        if (i > 1 && num[i] == num[i - 2]) continue;
    	
        for (int j = i + 1; j < num.length; j++) {
            // get rid of repeated pair sums
            if (j > i + 2 && num[j] == num[j - 2]) continue;

            // for each pair sum, check if the pair sum that is needed to get the target has been visited.            	
            if (twoSumMap.containsKey(target - (num[i] + num[j]))) {   
                // if so, get all the pairs that contribute to this visited pair sum.
        	List<int[]> ls = twoSumMap.get(target - (num[i] + num[j]));
        		
        	for (int[] pair : ls) {
        	    // we have two pairs: one is indicated as (pair[0], pair[1]), the other is (i, j).
        	    // we first need to check if they are overlapping with each other.
        	    int m1 = Math.min(pair[0], i);  // m1 will always be the smallest index
                    int m2 = Math.min(pair[1], j);  // m2 will be one of the middle two indices
                    int m3 = Math.max(pair[0], i);  // m3 will be one of the middle two indices
                    int m4 = Math.max(pair[1], j);  // m4 will always be the largest index
                    
                    if (m1 == m3 || m1 == m4 || m2 == m3 || m2 == m4) continue;  // two pairs are overlapping, so just ignore this case
 		    
 		    res.add(Arrays.asList(num[m1], num[Math.min(m2, m3)], num[Math.max(m2, m3)], num[m4]));  // else record the result
        	}
            }
            
            // mark that we have visited current pair and add it to the corrsponding pair sum group.
            // here we've encoded the pair indices i and j into an integer array of length 2.
            twoSumMap.computeIfAbsent(num[i] + num[j], key -> new ArrayList<>()).add(new int[] {i, j});
        }
    }
    
    return new ArrayList<List<Integer>>(res);
}
}