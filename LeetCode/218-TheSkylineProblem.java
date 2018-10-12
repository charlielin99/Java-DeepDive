class Solution {
    /*
    Observations:

If a position is shadowed by other buildings

 1. height of that building is larger than the building to which current
     position belong;
 2. the start point of that building must be smaller(or equal to) than this
     position;
 3. the end point of that building must be larger(or equal to) than this
     position;
     
     
     Firstly, please notice what we need to achieve:

  1. visit all start points and all end points in order;
  2. when visiting a point, we need to know whether it is a start point or a
      end point, based on which we can add a height or delete a height from
      our data structure;
To achieve this, his implementation:

  1. use a int[][] to collect all [start point, - height] and [end point, height]
      for every building;
  2. sort it, firstly based on the first value, then use the second to break
      ties;
Thus,

  1. we can visit all points in order;
  2. when points have the same value, higher height will shadow the lower one;
  3. we know whether current point is a start point or a end point based on the
      sign of its height;
      
      
      o(n) time and space
    */
public List<int[]> getSkyline(int[][] buildings) {
    List<int[]> result = new ArrayList<>();
    List<int[]> height = new ArrayList<>();
    for(int[] b:buildings) {
        // start point has negative height value
        height.add(new int[]{b[0], -b[2]});
        // end point has normal height value
        height.add(new int[]{b[1], b[2]}); 
    }

    // sort $height, based on the first value, if necessary, use the second to
    // break ties
    Collections.sort(height, (a, b) -> {
            if(a[0] != b[0]) 
                return a[0] - b[0];
            return a[1] - b[1];
    });

    // Use a maxHeap to store possible heights
    Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

    // Provide a initial value to make it more consistent
    pq.offer(0);

    // Before starting, the previous max height is 0;
    int prev = 0;

    // visit all points in order
    for(int[] h:height) {
        if(h[1] < 0) { // a start point, add height
            pq.offer(-h[1]);
        } else {  // a end point, remove height
            pq.remove(h[1]);
        }
        int cur = pq.peek(); // current max height;
  
        // compare current max height with previous max height, update result and 
        // previous max height if necessary
        if(prev != cur) {
            result.add(new int[]{h[0], cur});
            prev = cur;
        }
    }
    return result;
}
}