/*
A tree is a graph that doesn't have a cycle.
BFS. When a node is polled from queue, iterate through its neighbors. If any of them is visited but not the node's parent, there is a cycle.
1. If there are no edges, then the graph is a tree only if it has only one node.
2. Build graph. Use a map of int -> list of int. Iterate through the edge list and add nodes into map.
3. BFS. Poll a node from queue. Iterate through its neighbors. If queue contains a neighbor, that means there is a cycle in the graph. Return false. Otherwise, if the neighbor is not visited, offer it to queue.


Building graph takes O(E). BFS takes O(V + VE) = O(VE) because queue.contains() is not constant time. So the overall time complexity is O(VE).
*/


public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length == 0) {
            return n == 1;
        }
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            List<Integer> neighbors1 = graph.getOrDefault(edge[0], new ArrayList<>());
            List<Integer> neighbors2 = graph.getOrDefault(edge[1], new ArrayList<>());
            neighbors1.add(edge[1]);
            neighbors2.add(edge[0]);
            graph.put(edge[0], neighbors1);
            graph.put(edge[1], neighbors2);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(edges[0][0]);
        visited.add(edges[0][0]);
        int nodes = 0;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            nodes++;
            
            for (int neighbor : graph.get(node)) {
                if (queue.contains(neighbor)) {
                    return false;
                }
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return nodes == n;
    }
}