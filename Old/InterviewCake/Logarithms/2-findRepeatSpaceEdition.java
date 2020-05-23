import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Solution {

    public static int findRepeat(int[] theArray) {
        
        int floor = 1;
        int ceil = theArray.length - 1;
        
        while (floor < ceil){
            int midWay = floor + (ceil-floor)/2;
            int lowerFloor = floor;
            int lowerCeil = midWay;
            int higherFloor = midWay + 1;
            int higherCeil = ceil;
            
            int countLowRange = 0;
            
            for (int num: theArray){
                if (num >= lowerFloor && num <= lowerCeil){
                    countLowRange ++;
                }
            }
            
            int distinctPossibleLow = lowerCeil - lowerFloor + 1;
            
            if (countLowRange > distinctPossibleLow){
                floor = lowerFloor;
                ceil = lowerCeil;
            } else {
                floor = higherFloor;
                ceil = higherCeil;
            }
        }
        
        return floor;
    }


















    // tests

    @Test
    public void justTheRepeatedNumberTest() {
        final int[] numbers = {1, 1};
        final int expected = 1;
        final int actual = findRepeat(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void shortArrayTest() {
        final int[] numbers = {1, 2, 3, 2};
        final int expected = 2;
        final int actual = findRepeat(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void mediumArrayTest() {
        final int[] numbers = {1, 2, 5, 5, 5, 5};
        final int expected = 5;
        final int actual = findRepeat(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void longArrayTest() {
        final int[] numbers = {4, 1, 4, 8, 3, 2, 7, 6, 5};
        final int expected = 4;
        final int actual = findRepeat(numbers);
        assertEquals(expected, actual);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Solution.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}