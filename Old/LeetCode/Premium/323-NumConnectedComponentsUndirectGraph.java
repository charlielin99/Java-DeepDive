/*
This question is a good practice on union-find.
The idea is to think of each connected component as a tree. As we iterate through the edges, we set one of the node as the parent node of the other and decrement n. This process is called union, which essentially adds the nodes into the tree they belong to. Before we can union two nodes, we need to check if they are already on the same tree, in order not to decrement n by mistake. This can be done by comparing the two root nodes of the trees the nodes belong to. This process is the find part.

Say there are v nodes and e edges. Union takes O(e) loops where each loop may take O(v) time. So the overall time complexity is O(ve).
*/

public class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] roots = new int[n];
        
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
        
        for (int i = 0; i < edges.length; i++) {
            int r1 = find(roots, edges[i][0]);
            int r2 = find(roots, edges[i][1]);
            
            if (r1 != r2) {
                roots[r1] = r2;
                n--;
            }
        }
        
        return n;
    }
    
    private int find(int[] roots, int key) {
        while (roots[key] != key) {
            key = roots[key];
        }
        
        return key;
    }
}