import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Solution {

    public static Set<String> getPermutations(String inputString) {
        if (inputString.length() <= 1){
            return new HashSet<>(Collections.singletonList(inputString));
        }
        
        String allCharsExceptLast = inputString.substring(0, inputString.length() -1);
        char lastChar = inputString.charAt(inputString.length() -1);
        
        Set<String> permutationsOfAllCharsExceptLast = getPermutations(allCharsExceptLast);
        
        Set<String> permutations = new HashSet<>();
        
        for (String permutationOfAllCharsExceptLast: permutationsOfAllCharsExceptLast){
            for (int position = 0; position <= allCharsExceptLast.length(); position++){
                String permutation = permutationOfAllCharsExceptLast.substring(0, position)
                                     +lastChar + permutationOfAllCharsExceptLast.substring(position);
                permutations.add(permutation);
            }
        }
        
        return permutations;
    }


















    // tests

    @Test
    public void emptyStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList(""));
        final Set<String> actual = getPermutations("");
        assertEquals(expected, actual);
    }

    @Test
    public void oneCharacterStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList("a"));
        final Set<String> actual = getPermutations("a");
        assertEquals(expected, actual);
    }

    @Test
    public void twoCharacterStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList("ab", "ba"));
        final Set<String> actual = getPermutations("ab");
        assertEquals(expected, actual);
    }

    @Test
    public void threeCharacterStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList("abc", "acb", "bac", "bca",
                                                                 "cab", "cba"));
        final Set<String> actual = getPermutations("abc");
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