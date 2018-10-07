/*Never use Double as HashMap's key.

Use
String slope= yDiff/(gcd(yDiff, xDiff)) +"," + xDiff/gcd(yDiff, xDiff)
instead of
double slope=(double) yDifference/ (double) xDifference
*/

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if(points==null) return 0;
        else if(points.length<=2) return points.length;
        int maxPoints=0;
        boolean[] usedPoint=new boolean[points.length];
        boolean[] usedInVertical=new boolean[points.length];
        boolean[] usedInParallel=new boolean[points.length];
        for(int i=0; i<points.length-maxPoints; i++){
            if(usedPoint[i]) continue; //pass the duplicated points
            int numOfSamePoint=1; //number of points same as points[i]
            int numOfVerticalPoint=0; //number of points on the line parallel to y axis, exclude points[i]
            int numOfParallelPoint=0; //number of points on the line parallel to x axis, exclude points[i]
            int curMax=0; //exclude points[i]
            HashMap<String, Integer> map=new HashMap<>();
            for(int j=i+1; j<points.length; j++){
                if(usedPoint[j]) continue;
                else if(points[j].x==points[i].x && points[j].y==points[i].y){
                    numOfSamePoint++;
                    usedPoint[j]=true;
                }else if(!usedInVertical[i] && points[j].x==points[i].x){
                    numOfVerticalPoint++;
                    usedInVertical[j]=true;
                }else if(!usedInParallel[i] && points[j].y==points[i].y){
                    numOfParallelPoint++;
                    usedInParallel[j]=true;
                }else{
                    /*Can't use double as key, use the minimal integer value of "(y2-y1), (x2-x1)" to represent slope */
                    String slope=getSlope(points[i], points[j]);
                    int count=map.getOrDefault(slope, 0)+1;
                    map.put(slope, count);
                    curMax=Math.max(curMax, count);
                }
            }
            if(!usedInVertical[i]) curMax=Math.max(curMax, numOfVerticalPoint);
            if(!usedInParallel[i]) curMax=Math.max(curMax, numOfParallelPoint);
            maxPoints=Math.max(maxPoints, curMax+numOfSamePoint);
            usedPoint[i]=true;
            usedInVertical[i]=true;
            usedInParallel[i]=true;
        }
        return maxPoints;
    }
    
     /*calculate the greatest common divisor*/
    private int generateGCD(int a, int b){
        while(b!=0){
            int c=a%b;
            a=b;
            b=c;
        }
        return a;
    }
    
    private String getSlope(Point pi, Point pj){
        int yDiff=pj.y-pi.y, xDiff=pj.x-pi.x;
        int gcd=generateGCD(yDiff, xDiff);
        return yDiff/gcd+","+xDiff/gcd;
    }
}