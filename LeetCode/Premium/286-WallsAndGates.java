//Iterate through the grid. Add gates' coordinates to queue. BFS from gates and expand through all rooms.
//Each vertex's number of edges is constant. The overall time complexity is O(V).

public class Solution {
    private final int[][] DIRECTIONS = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
    
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{ i, j });
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int[] room = queue.poll();
            int distance = rooms[room[0]][room[1]];
            
            for (int i = 0; i < 4; i++) {
                int row = room[0] + DIRECTIONS[i][0];
                int column = room[1] + DIRECTIONS[i][1];
                
                if (row >= 0 && row < rooms.length && column >= 0 && column < rooms[0].length) {
                    if (rooms[row][column] == Integer.MAX_VALUE) {
                        rooms[row][column] = distance + 1;
                        queue.offer(new int[]{ row, column });
                    }
                }
            }
        }
    }
}