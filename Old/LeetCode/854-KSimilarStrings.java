class Solution {
/*
In fact, the essence of the problem is to get the minimum number of swaps A needs to make itself equal to B.

It is a shortest-path problem so we can utilize BFS. The graph we build sets all possible strings that can be swapped from A as nodes, and an edge exists if one string can be transformed into the other by one swap. We start at A, and target at B.

However, that will cause TLE. We set all possible strings that can be formed by swapping the positions of two letters in A' one time as neighbours of A', however, only those can make A and B differ less are meaningful neighbours. That is, if A'[i] != B[i] but A'[j] == B[i], the string formed by swap(A, i, j) is a meaningful neighbour of A'. Please note that we just need to swap the first pair (A'[i], A'[j]) we meet for the order of swap doesn't matter.

time: O(n) based on length of A, because we are swapping A to become B
*/

    public int kSimilarity(String A, String B) {

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(A);
        visited.add(A);
        int level = 0;

        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                String curNode = queue.poll();
                if (curNode.equals(B)) {
                    return level;
                }
                for (String neighbour : getNeighbours(curNode, B)) {
                    if (!visited.contains(neighbour)) {
                        queue.offer(neighbour);
                        visited.add(neighbour);
                    }
                }
            }
            level++;
        }

        return -1;
    }
    
    private List<String> getNeighbours(String S, String B) { 
        
        List<String> result = new ArrayList<>();
        char[] arr = S.toCharArray(); 
        
        int i = 0;
        for (; i < arr.length; i++) {
            if (arr[i] != B.charAt(i)) {
                break;
            }
        }
                
        for (int j = i + 1; j < arr.length; j++) { 
            if (arr[j] == B.charAt(i)) {
                swap(arr, i, j);             
                result.add(new String(arr));
                swap(arr, i, j);
            }
        }     
        
        return result;
    }
    
    private void swap(char[] arr, int i, int j) {
        
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}