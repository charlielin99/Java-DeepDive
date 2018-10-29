class Solution {
    // time o(n lg n)
    public int kEmptySlots(int[] flowers, int k) {
        if (flowers == null || flowers.length < 1) {
            return -1;
        }
        
        // core logic
        TreeSet<Integer> bloomingTreeSet = new TreeSet<>();
        int day = 0;
        for(int flower: flowers) {
            day++;
            bloomingTreeSet.add(flower);
            Integer higher = bloomingTreeSet.higher(flower);
            Integer lower = bloomingTreeSet.lower(flower);
            if (higher != null && higher - flower - 1 == k || 
                lower != null && flower - lower - 1 == k ) {
                return day;
            }
        }
        
        return -1;
     }
}