import java.util.Arrays;
import java.util.Random;

public class Solution {

    private static Random rand = new Random();

    private static int getRandom(int floor, int ceiling) {
        return rand.nextInt((ceiling - floor) + 1) + floor;
    }

    public static void shuffle(int[] theArray) {
        
        if (theArray.length <= 1){
            return;
        }

        // shuffle the input in place
        int shufflingIndex = 0;
        
        while (shufflingIndex < theArray.length){
            int randomIndex = getRandom(shufflingIndex, theArray.length-1);
            
            if (randomIndex != shufflingIndex){
                int temp = theArray[shufflingIndex];
                theArray[shufflingIndex] = theArray[randomIndex];
                theArray[randomIndex] = temp;
            }
            
            shufflingIndex++;
        }

    }

    public static void main(String[] args) {
        final int[] initial = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        final int[] shuffled = Arrays.copyOf(initial, initial.length);
        shuffle(shuffled);
        System.out.printf("initial array: %s\n", Arrays.toString(initial));
        System.out.printf("shuffled array: %s\n", Arrays.toString(shuffled));
    }
}