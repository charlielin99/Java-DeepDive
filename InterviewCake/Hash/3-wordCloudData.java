import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

import static org.junit.Assert.*;

public class Solution {

    public static class WordCloudData {

        private Map<String, Integer> wordsToCounts = new HashMap<>();

        private void populateWordsToCounts(String inputString) {
            int currentWordStartIndex = 0;
            int currentWordLength = 0;
            
            for (int i=0; i<inputString.length(); i++){
                char character = inputString.charAt(i);
                
                if (i == inputString.length() - 1){
                    if (Character.isLetter(character)){
                        currentWordLength++;
                    }
                    if (currentWordLength > 0){
                        String currentWord = inputString.substring(currentWordStartIndex, 
                            currentWordStartIndex + currentWordLength);
                        addWordToHashMap(currentWord);
                    }
                } else if (character == ' ' || character == '\u2014'){
                    if (currentWordLength > 0){
                        String currentWord = inputString.substring(currentWordStartIndex, 
                            currentWordStartIndex + currentWordLength); 
                        addWordToHashMap(currentWord);
                        currentWordLength = 0;
                    }
                } else if (character == '.'){
                    if (i < inputString.length() - 1 && inputString.charAt(i + 1) == '.') {
                        if (currentWordLength > 0) {
                            String currentWord = inputString.substring(currentWordStartIndex,
                                currentWordStartIndex + currentWordLength);
                            addWordToHashMap(currentWord);
                            currentWordLength = 0;
                        }
                    }
                } else if (Character.isLetter(character) || character == '\'') {
                    if (currentWordLength == 0) {
                        currentWordStartIndex = i;
                    }
                    currentWordLength++;
                } else if (character == '-') {
                    if (i > 0 && Character.isLetter(inputString.charAt(i - 1))&& Character.isLetter(inputString.charAt(i + 1))) {
                        if (currentWordLength == 0) {
                            currentWordStartIndex = i;
                        }
                        currentWordLength++;
                    } else {
                        if (currentWordLength > 0) {
                            String currentWord = inputString.substring(currentWordStartIndex,
                                currentWordStartIndex + currentWordLength);
                            addWordToHashMap(currentWord);
                            currentWordLength = 0;
                        }
                    }
                }
            }
        }

        public WordCloudData(String inputString) {
            populateWordsToCounts(inputString);
        }

        public Map<String, Integer> getWordsToCounts() {
            return wordsToCounts;
        }
        
        private void addWordToHashMap(String word) {

            // if the word is already in the hash map we increment its count
            if (wordsToCounts.containsKey(word)) {
                wordsToCounts.put(word, wordsToCounts.get(word) + 1);

            // if a lowercase version is in the hash map, we know our input word must be uppercase
            // but we only include uppercase words if they're always uppercase
            // so we just increment the lowercase version's count
            } else if (wordsToCounts.containsKey(word.toLowerCase())) {
                int newCount = wordsToCounts.get(word.toLowerCase()) + 1;
                wordsToCounts.put(word.toLowerCase(), newCount);

            // if an uppercase version is in the hash map, we know our input word must be lowercase.
            // since we only include uppercase words if they're always uppercase, we add the
            // lowercase version and give it the uppercase version's count
            } else if (wordsToCounts.containsKey(capitalize(word))) {
                int newCount = wordsToCounts.get(capitalize(word)) + 1;
                wordsToCounts.put(word, newCount);
                wordsToCounts.remove(capitalize(word));

            // otherwise, the word is not in the hash map at all, lowercase or uppercase
            // so we add it to the hash map
            } else {
                wordsToCounts.put(word, 1);
            }
        }

        private String capitalize(String word) {
            return word.substring(0, 1).toUpperCase() + word.substring(1);
        }
    }


















    // tests

    // There are lots of valid solutions for this one. You
    // might have to edit some of these tests if you made
    // different design decisions in your solution.

    @Test
    public void simpleSentenceTest() {
        final String text = "I like cake";
        final Map<String, Integer> expected = new HashMap<String, Integer>() { {
            put("I", 1);
            put("like", 1);
            put("cake", 1);
        }};
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
    }

    @Test
    public void longerSentenceTest() {
        final String text = "Chocolate cake for dinner and pound cake for dessert.";
        final Map<String, Integer> expected = new HashMap<String, Integer>() { {
            put("and", 1);
            put("pound", 1);
            put("for", 2); 
            put("dessert", 1);
            put("Chocolate", 1);
            put("dinner", 1);
            put("cake", 2);
        }};
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
    }

    @Test
    public void punctuationTest() {
        final String text = "Strawberry short cake? Yum!";
        final Map<String, Integer> expected = new HashMap<String, Integer>() { {
            put("cake", 1);
            put("Strawberry", 1);
            put("short", 1);
            put("Yum", 1);
        }};
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
    }

    @Test
    public void hyphenatedWordsTest() {
        final String text = "Dessert - mille-feuille cake";
        final Map<String, Integer> expected = new HashMap<String, Integer>() { {
            put("cake", 1);
            put("Dessert", 1);
            put("mille-feuille", 1);
        }};
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
    }

    @Test
    public void ellipsesBetweenWordsTest() {
        final String text = "Mmm...mmm...decisions...decisions";
        final Map<String, Integer> expected = new HashMap<String, Integer>() { {
                put("mmm", 2);
                put("decisions", 2); 
        }};
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
    }

    @Test
    public void apostrophesTest() {
        final String text = "Allie's Bakery: Sasha's Cakes";
        final Map<String, Integer> expected = new HashMap<String, Integer>() { {
            put("Bakery", 1);
            put("Cakes", 1);
            put("Allie's", 1);
            put("Sasha's", 1);
        }};
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
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