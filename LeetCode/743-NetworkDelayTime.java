class Solution {
    /*
    It is a direct graph.

    Use Map<Integer, Map<Integer, Integer>> to store the source node, target node and the distance between them.
    Offer the node K to a PriorityQueue.
    Then keep getting the closest nodes to the current node and calculate the distance from the source (K) to this node (absolute       distance). Use a Map to store the shortest absolute distance of each node.
    Return the node with the largest absolute distance.
    */
    
    // time: O(E log V) with the help of heap
    
    public int networkDelayTime(int[][] times, int N, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0])); //{distance, node}
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] time : times) {
            map.putIfAbsent(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }
        int[] dis = new int[N+1]; //record the minimal distance of each node to K
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[K] = 0;
        boolean[] visited = new boolean[N+1];
        pq.offer(new int[]{0, K});
        int res = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[1];
            if (visited[curNode]) continue;
            visited[curNode] = true;
            int curDis = cur[0];
            res = curDis;
            N--;
            if (!map.containsKey(curNode)) continue;
            for (int next : map.get(curNode).keySet()) {
                if (!visited[next] && curDis + map.get(curNode).get(next) < dis[next]) {
                    dis[next] = curDis + map.get(curNode).get(next);
                    pq.offer(new int[]{dis[next], next});
                }
            }
        }
        return N == 0 ? res : -1;
    }
}