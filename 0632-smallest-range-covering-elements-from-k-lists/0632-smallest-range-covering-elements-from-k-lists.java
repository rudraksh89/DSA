class Solution {
    
    class Triplet implements Comparable<Triplet>{
        int val;
        int x;
        int y;
        Triplet(int val, int x, int y){
            this.val = val;
            this.x = x;
            this.y = y;
        }

        public int compareTo(Triplet t){
            return Integer.compare(this.val,t.val);
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;

        for(int i=0;i<nums.size();i++){
            int value = nums.get(i).get(0);
            pq.offer(new Triplet(value,i,0));
            max = Math.max(max,value);
        }

        int start = 0;
        int end = Integer.MAX_VALUE;
        while(true){
            Triplet curr = pq.remove();
            int min = curr.val;
            if ((max - min) < (end - start) ||
                ((max - min) == (end - start) && min < start)) {
                start = min;
                end = max;
            }
            if(curr.y+1 == nums.get(curr.x).size()) break;
            int next = nums.get(curr.x).get(curr.y + 1);
            pq.offer(new Triplet(next,curr.x,curr.y+1));
            max = Math.max(max,next);
        }
        return new int[]{start,end};
    }
}