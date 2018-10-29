class Solution {
    // time O(N^2*W)
    // N is A.length
    // W is A[0].length
    public int numSimilarGroups(String[] A) {
        if( A == null || A.length == 0) {
            return 0;
        }
        
        boolean[] visited = new boolean[A.length];
        Queue<String> queue = new LinkedList<>();
        
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            if(visited[i]) {
                continue;
            }
            
            visited[i] = true;
            ans++;
            queue.add(A[i]);
            while(!queue.isEmpty()) {
                String sameGroup = queue.poll();
                for (int j = 0; j < A.length; j++) {
                    if(visited[j]) {
                        continue;
                    }
                    int diff = 0;
                    for (int l = 0; l < A[j].length(); l++) {
                        if(sameGroup.charAt(l) != A[j].charAt(l)) {
                            diff++;
                        }
                    }
                    //important here, "aaaaa", "aaaaa" should be grouped together
                    if(diff == 2 || (diff == 0 && sameGroup.length() >=2)) {
                        visited[j] = true;
                        queue.add(A[j]);
                    }
                }
            }
            
        }
        return ans;
    }
}