class Solution {

    class Pair implements Comparable<Pair>{
        String s;
        int val;
        Pair(String s, int val){
            this.s = s;
            this.val = val;
        }
        public int compareTo(Pair p){
            if(this.val == p.val) return p.s.compareTo(this.s);
            return Integer.compare(this.val,p.val);
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> mp = new HashMap<>();
        for(int i=0;i<words.length;i++){
            String st = words[i];
            mp.put(st,mp.getOrDefault(st,0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        List<String> l = new ArrayList<>();
        
        for(Map.Entry<String,Integer> e : mp.entrySet()){
            String key = e.getKey();
            int val = e.getValue();
            pq.add(new Pair(key,val));
            if(pq.size() > k) pq.remove();
        }

        while(pq.size() > 0){
            Pair p = pq.remove();
            l.add(p.s);
        }
        Collections.reverse(l);
        return l;
    }
}
