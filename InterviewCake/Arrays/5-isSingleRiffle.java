import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Solution {

    public static boolean isSingleRiffle(int[] half1, int[] half2, int[] shuffledDeck) {

        // check if the shuffled deck is a single riffle of the halves
        int half1Counter = 0;
        int half2Counter = 0;
        
        for (int card: shuffledDeck){
            if (half1Counter < half1.length && half1[half1Counter] == card){
                half1Counter++;
            } else if (half2Counter < half2.length && half2[half2Counter] == card){
                half2Counter++;
            } else {
                return false;
            }
        }

        return true;
    }


















    // tests

    @Test
    public void bothHalvesAreTheSameLengthTest() {
        final int[] half1 = {1, 4, 5};
        final int[] half2 = {2, 3, 6};
        final int[] shuffledDeck = {1, 2, 3, 4, 5, 6};
        final boolean result = isSingleRiffle(half1, half2, shuffledDeck);
        assertTrue(result);
    }

    @Test
    public void halvesAreDifferentLengthsTest() {
        final int[] half1 = {1, 5};
        final int[] half2 = {2, 3, 6};
        final int[] shuffledDeck = {1, 2, 6, 3, 5};
        final boolean result = isSingleRiffle(half1, half2, shuffledDeck);
        assertFalse(result);
    }

    @Test
    public void oneHalfIsEmptyTest() {
        final int[] half1 = {};
        final int[] half2 = {2, 3, 6};
        final int[] shuffledDeck = {2, 3, 6};
        final boolean result = isSingleRiffle(half1, half2, shuffledDeck);
        assertTrue(result);
    }

    @Test
    public void shuffledDeckIsMissingCardsTest() {
        final int[] half1 = {1, 5};
        final int[] half2 = {2, 3, 6};
        final int[] shuffledDeck = {1, 6, 3, 5};
        final boolean result = isSingleRiffle(half1, half2, shuffledDeck);
        assertFalse(result);
    }

    @Test
    public void shuffledDeckHasExtraCards() {
        final int[] half1 = {1, 5};
        final int[] half2 = {2, 3, 6};
        final int[] shuffledDeck = {1, 2, 3, 5, 6, 8};
        final boolean result = isSingleRiffle(half1, half2, shuffledDeck);
        assertFalse(result);
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