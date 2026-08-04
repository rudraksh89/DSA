class Solution {

    class Pair implements Comparable<Pair>{
        int val;
        int freq;
        Pair(int val, int freq){
            this.val = val;
            this.freq = freq;
        }
        public int compareTo(Pair p){
            if(this.freq == p.freq) return Integer.compare(this.val,p.val);
            return Integer.compare(this.freq,p.freq);
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> mp = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        List<Integer> l = new ArrayList<>();
        for(int i=0;i<n;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }

        for(Map.Entry<Integer,Integer> e : mp.entrySet()){
            int key = e.getKey();
            int value = e.getValue();
            pq.add(new Pair(key,value));
            if(pq.size() > k) pq.remove();
        }

        while(pq.size() > 0){
            Pair top = pq.remove();
            l.add(top.val);
        }
        int[] res = new int[l.size()];
        for(int i=0;i<res.length;i++){
            res[i] = l.get(i);
        }
        return res;


    }
}