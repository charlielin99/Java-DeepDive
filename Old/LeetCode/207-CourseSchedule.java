class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {   
        
        // time: O(V + E)
        // topological sort
        
        int[][] edgeMatrix = new int[numCourses][numCourses];
        int[] incomingEdge = new int[numCourses];
        
        //build adj matrix
        for(int k = 0; k < prerequisites.length; k++) {
            int i = prerequisites[k][1];
            int j = prerequisites[k][0];
            
            if(edgeMatrix[i][j] == 0) {
                incomingEdge[j]++;
            }
            edgeMatrix[i][j] = 1;
        }
        
        //build queue for all nodes with no edges
        Queue<Integer> nodesWithNoEdges = new LinkedList<>();
        for(int n = 0; n < incomingEdge.length; n++) {
            if(incomingEdge[n] == 0) {
                nodesWithNoEdges.add(n);
            }
        }
        
        int courseCount = 0;
        //process queue
        while(!nodesWithNoEdges.isEmpty()) {
            int i = nodesWithNoEdges.poll();
            courseCount++;
            
            //go through adj matrix and start removing edges from i -> j
            for(int j = 0; j < edgeMatrix[0].length; j++) {
                if(edgeMatrix[i][j] != 0) { //edge found
                    incomingEdge[j]--;  //remove edge
                    
                    if(incomingEdge[j] == 0) { //no edges left for this node
                        nodesWithNoEdges.add(j);
                    }
                }
            }
        }
        
        return courseCount == numCourses;
    }
}