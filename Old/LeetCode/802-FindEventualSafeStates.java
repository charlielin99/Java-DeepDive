/*
value of color represents three states:
0:have not been visited
1:safe
2:unsafe
For DFS,we need to do some optimization.When we travel a path,we mark the node with 2 which represents having been visited,and when we encounter a node which results in a cycle,we return false,all node in the path stays 2 and it represents unsafe.And in the following traveling,whenever we encounter a node which points to a node marked with 2,we know it will results in a cycle,so we can stop traveling.On the contrary,when a node is safe,we can mark it with 1 and whenever we encounter a safe node,we know it will not results in a cycle.

time / space: O(V+E)
*/

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        if(graph == null || graph.length == 0)  return res;
        
        int nodeCount = graph.length;
        int[] color = new int[nodeCount];
        
        for(int i = 0;i < nodeCount;i++){
            if(dfs(graph, i, color))    res.add(i);
        }
        
        return res;
    }
    public boolean dfs(int[][] graph, int start, int[] color){
        if(color[start] != 0)   return color[start] == 1;
        
        color[start] = 2;
        for(int newNode : graph[start]){
            if(!dfs(graph, newNode, color))    return false;
        }
        color[start] = 1;
        
        return true;
    }
}