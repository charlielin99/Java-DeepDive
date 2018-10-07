import java.util.*;

public class Solution {

    public static class CakeType {

        final int weight;
        final int value;

        public CakeType(int weight, int value) {
            this.weight = weight;
            this.value  = value;
        }
    }
    
    public static class InfinityException extends RuntimeException{
        public InfinityException(){
            super("Max value is infinity!");
        }
    }

    public static Map<Integer, Integer> maxDuffelBagValue(CakeType[] cakeTypes, int weightCapacity) {

        long[] maxValuesAtCapacities = new long[weightCapacity + 1];
        HashMap<Integer, Integer>[] maxIndexesAtCapacities = new HashMap[weightCapacity + 1];

        for (int currentCapacity = 0; currentCapacity <= weightCapacity; currentCapacity++) {
            long currentMaxValue = 0;
            int currentMaxCake = -1, prevMaxIndex = -1;

            for (CakeType cakeType : cakeTypes) {
                if (cakeType.weight == 0 && cakeType.value != 0) {
                    throw new InfinityException();
                }

                if (cakeType.weight <= currentCapacity) {
                    long maxValueUsingCake = cakeType.value + maxValuesAtCapacities[currentCapacity - cakeType.weight];
                    if (maxValueUsingCake > currentMaxValue) {
                        currentMaxValue = maxValueUsingCake;
                        currentMaxCake = cakeType.value;
                        prevMaxIndex = currentCapacity - cakeType.weight;
                    }
                }
            }

            maxValuesAtCapacities[currentCapacity] = currentMaxValue;
            if (prevMaxIndex < 0) {
                maxIndexesAtCapacities[currentCapacity] = new HashMap<>();
            } else {
                HashMap<Integer, Integer> currHashMap = new HashMap<>(maxIndexesAtCapacities[prevMaxIndex]);
                if (currHashMap.get(currentMaxCake) == null) {
                    currHashMap.put(currentMaxCake, 1);
                } else {
                    currHashMap.put(currentMaxCake, currHashMap.get(currentMaxCake) + 1);
                }
                maxIndexesAtCapacities[currentCapacity] = currHashMap;
            }
        }

        return maxIndexesAtCapacities[weightCapacity];
    }
}