/*
My solution is quite straightforward. As any pair of two different points can determine a line. So I go through all the points-pairs, get lines of each pair, store lines as the key in HashMap, then store each point into HasSet belongs to a certain line. Finally, count how many points on each line and select the max.

Here is the equation of a line:

y = k * x + c
Reference: https://www.mathsisfun.com/equation_of_line.html

So first I defined a class named Line, based on the equation of line in Math, y = k * x + c, in my Line class it has four properties:

vertical, a boolean variable, if vertical is true it means the line is a vertical which is parallel with the y-axis;
horizontal, a boolean variable, if horizontal is true it means the line is a horizontal which is parallel with the x-axis;
k, an integer variable which means the slope of a line;
c, an integer variable which means the y-intercept of a line.
Say if we have two points: (x1, y1), (x2, y2), then we can calculate the slope k and the y-intercept if and only if the line is not a vertical:

1. k = (y2 - y1) / (x2 - x1);
2. c = (x2 * y1 - x1 * y1) / (x2 - x1);
Here is one thing we need to take care, as we use integer type to store the slope k and y-intercept c, we need to keep three decimal places for them, so inside the Line class we need to multiply both k and c by 1000.

Another thing is we need to let the HashMap know how to identify each line. So inside the Line class we override both methods of equals(Object obj) and hashCode().

Time: O(n^2)
Space: O(N) 
*/


public class Solution {
    public int maxPoints(Point[] points) {
        if (points.length < 3) {
            return points.length;
        }
        int max = Integer.MIN_VALUE;
        Map<Line, Set<Point>> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                Point p1 = points[i];
                Point p2 = points[j];
                Line l = new Line(p1, p2);
                if (!map.containsKey(l)) {
                    map.put(l, new HashSet<>());
                }
                map.get(l).add(p1);
                map.get(l).add(p2);
                max = Math.max(max, map.get(l).size());
            }
        }
        return max;
    }
}

class Line {
    // y = k * x + c
    boolean vertical;
    boolean horizontal;
    int k;
    int c;
    public Line(Point p1, Point p2) {
        vertical = false;
        horizontal = false;
        if (p1.x == p2.x) {
            vertical = true;
            c = p1.x * 1000;
        } else if (p1.y == p2.y) {
            horizontal = true;
            c = p1.y * 1000;
        } else {
            k = 1000 * (p2.y - p1.y) / (p2.x - p1.x);
            c = 1000 * (p2.x * p1.y - p1.x * p2.y) / (p2.x - p1.x);
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + c;
        result = prime * result + (horizontal ? 1231 : 1237);
        result = prime * result + k;
        result = prime * result + (vertical ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Line other = (Line) obj;
        if (c != other.c)
            return false;
        if (horizontal != other.horizontal)
            return false;
        if (k != other.k)
            return false;
        if (vertical != other.vertical)
            return false;
        return true;
    }
}