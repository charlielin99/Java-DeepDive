class Solution {
/*
Time: O(n)
And edge will connect two nodes into one connected component.
When we count an edge in, if the two nodes have already been in the same connected component, the edge will result in a cycle, so it is redundant.

We can make use of Disjoint Sets (Union Find):
Initially, each node can be regarded as a disjoint set.
When we count an edge in, we UNION two nodes,
If two nodes have already been in the same disjoint set (we detect that with the help of FIND), the current edge is redundant.

For example,

  1
 / \
2 - 3
Initially, there are 3 disjoint sets: 1, 2, 3.
Edge [1,2] connects 1 to 2, i.e., 1 and 2 are grouped together.
Edge [1,3] connects 1 to 3, i.e., 1 and 3 are grouped together.
Edge [2,3] connects 2 to 3, but 2 and 3 have been in the same disjoint set already, so [2, 3] is redundant.
*/
    
    static class DisjointSets {
        
        private static int[] parent;
        private static int[] rank;
        
        public DisjointSets(int n) {
            parent = new int[n];
            rank = new int[n];
            Arrays.fill(rank, 1);
        }
        
        public int find(int x) {
            if (0 == parent[x])
                return x;

            return parent[x] = find(parent[x]);
        }
        
        public boolean union(int x, int y) {
            
            int rootOfX = find(x), rootOfY = find(y);
            
            if (rootOfX != 0 && rootOfX == rootOfY)
                return false;
            
            if (rank[rootOfX] < rank[rootOfY]) {
                parent[rootOfX] = rootOfY;
                rank[rootOfY] += rank[rootOfX];
            } else {
                parent[rootOfY] = rootOfX;
                rank[rootOfX] += rank[rootOfY];
            }

            return true;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        
        DisjointSets disjointSets = new DisjointSets(edges.length + 1);
        int u, v;
        
        for (int[] edge : edges) {
            u = edge[0];
            v = edge[1];
            if (!disjointSets.union(u, v)) {
                return edge;
            }
        }
        
        return new int[2];
    }
}