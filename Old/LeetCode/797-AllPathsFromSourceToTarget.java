/*
One dfs solution is to traverse the graph from start node to the end, and keep track of each node along the path. Each node can be visited many times when it has multiple indegree.

Time complexity: O(n!)
Space complexity: O(n)
*/

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
					
        path.add(0);
        dfsSearch(graph, 0, res, path);
					
        return res;
    }

    private void dfsSearch(int[][] graph, int node, List<List<Integer>> res, List<Integer> path) {
        if (node == graph.length - 1) {
            res.add(new ArrayList<Integer>(path));
            return;
        }

        for (int nextNode : graph[node]) {
            path.add(nextNode);
            dfsSearch(graph, nextNode, res, path);
            path.remove(path.size() - 1); //backtracking remove as soon as it fails
            /*
            It's backtracking. We incrementally build candidates to the solution, and abandon a candidate ("backtrack") as soon                 as its determined that the candidate cannot possibly be completed to a valid solution.
            */
        }
    }
}