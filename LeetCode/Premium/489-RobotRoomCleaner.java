/*
DFS + Backtracking

Different from regular dfs to visit all, the robot move() function need to be called, backtrack needs to move() manually and backtracking path shold not be blocked by visited positions
- IMPORTANT: Mark on the way in using set, but `backtrack directly without re-check against set`
- Backtrack: turn 2 times to revert, move 1 step, and turn 2 times to revert back.

Time: O(n) it must traverse everything
*/


class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public void cleanRoom(Robot robot) {
        // use 'x@y' mark visited nodes, where x,y are integers tracking the coordinates
        dfs(robot, new HashSet<>(), 0, 0, 0); // 0: up, 90: right, 180: down, 270: left
    }
 
    public void dfs(Robot robot, Set<String> visited, int x, int y, int curDir) {
        String key = x + "@" + y;
        if (visited.contains(key)) return;
        visited.add(key);
        robot.clean();
 
        for (int i = 0; i < 4; i++) { // 4 directions
            if(robot.move()) { // can go directly. Find the (x, y) for the next cell based on current direction
                dfs(robot, visited, x + dx[curDir], y + dy[curDir], curDir);
                backtrack(robot);
            }
 
            // turn to next direction
            robot.turnRight();
            curDir += 1;
            curDir %= 4;
        }
    }
 
    // go back to the starting position
    private void backtrack(Robot robot) {
        robot.turnLeft();
        robot.turnLeft();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}　　