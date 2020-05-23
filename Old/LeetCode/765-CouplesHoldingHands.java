class Solution {
    // Time O(n)
  public int minSwapsCouples(int[] row) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // maps couples as alternating key value pairs
        int index = 0;
        int res = 0;
        while(index < row.length)
        {
            map.put(row[index],row[index + 1]);
            map.put(row[index + 1], row[index]);
            index = index + 2;
        }
        index = 0;
        while(index < row.length)
        {
            if(map.get(index) != index + 1)
            {
                int nextvalue = map.get(index + 1);
                int currentvalue = map.get(index);
                map.put(index, index + 1);
                map.put(currentvalue, nextvalue);
                map.put(nextvalue, currentvalue);
                res++;
            }
            index = index + 2;
        }
        return res;
    }
}