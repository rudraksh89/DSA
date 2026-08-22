class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer,Integer> mp = new TreeMap<>();
        for(int[] row : trips){
            mp.put(row[1],mp.getOrDefault(row[1],0)+row[0]);
            mp.put(row[2],mp.getOrDefault(row[2],0)-row[0]);
        }
        int curr = 0;

        for(Map.Entry<Integer,Integer> e : mp.entrySet()){
            int key = e.getKey();
            int val = e.getValue();
            curr += val;
            if(curr > capacity) return false;
        }
        return true;
    }
}