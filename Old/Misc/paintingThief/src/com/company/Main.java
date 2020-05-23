package com.company;

/*
Given a 2D array grid of size n*m with each value in the integer grid representing alarm timers and
a position on row r and column c that represents the final destination of the painting the thief wants to steal,
return if it is possible to reach that destination using any path.

Starting position is 0,0 and every grid traversed during a given path will have
its value reduced by 1 every subsequent step. If it is not possible to reach the final destination
without any of the grids hitting 0 (alarm rings), return false.

You can travel right left up down in the grid.

(Expected time complexity is 4^(n*m))
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) {
        System.out.println(hasWays(1, 1, new int[][]{
                {3, 1},
                {2, 4}
        }));

        System.out.println(hasWays(1, 1, new int[][]{
                {3, 1},
                {1, 4}
        }));


        System.out.println(hasWays(2, 2, new int[][]{
                {9, 6, 5, 4},
                {8, 7, 1, 3},
                {1, 1, 100, 2}
        }));
    }


    public static boolean hasWays(int r, int c, int[][] map) {
        Deque<Integer> xStack = new ArrayDeque<>();
        Deque<Integer> yStack = new ArrayDeque<>();
        Deque<Integer> pointStack = new ArrayDeque<>();

        //xStack and yStack are x y values
        //pointStack are the min alarm value so far (that's to be decreased)

        int xL = map.length, yL = map[0].length;
        int currX = 0, currY = 0, currPoint = map[0][0] + 1;

        xStack.push(currX);
        yStack.push(currY);
        pointStack.push(currPoint);

        while (!pointStack.isEmpty()) {
            currX = xStack.pop();
            currY = yStack.pop();
            currPoint = pointStack.pop();

            if (currX < 0 || currX >= xL || currY < 0 || currY >= yL || currPoint <= 0)
                continue;

            currPoint = Math.min(map[currX][currY], currPoint - 1);

            if (currX == r && currY == c && currPoint > 0)
                return true;

            xStack.push(currX - 1);
            yStack.push(currY);
            pointStack.push(currPoint);

            xStack.push(currX);
            yStack.push(currY - 1);
            pointStack.push(currPoint);

            xStack.push(currX + 1);
            yStack.push(currY);
            pointStack.push(currPoint);

            xStack.push(currX);
            yStack.push(currY + 1);
            pointStack.push(currPoint);
        }

        return false;
    }

}