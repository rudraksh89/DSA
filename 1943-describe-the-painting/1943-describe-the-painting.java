class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        List<List<Long>> l = new ArrayList<>();
        TreeMap<Integer,Long> mp = new TreeMap<>();
        
        for(int[] row : segments){
            int st = row[0];
            int en = row[1];
            int color = row[2];
            mp.put(st,mp.getOrDefault(st,0L)+color);
            mp.put(en,mp.getOrDefault(en,0L)-color);
        }

        int pre = mp.firstKey();
        long sum = 0;
        
        for(Map.Entry<Integer,Long> e : mp.entrySet()){
            int curr = e.getKey();
            if(pre != curr && sum > 0){
                l.add(Arrays.asList((long)pre,(long)curr,sum));
            }
            sum += e.getValue();
            pre = curr;
        }
        return l;
    }
}