class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        if(stones.length == 1) return stones[0];
        for(int ele : stones){
            pq.add(ele);
        }
        while(pq.size() > 1){
            int a = pq.remove();
            int b = pq.remove();
            if(a != b){
                pq.add(a-b);
            }else if(a == b) continue;
        }
        return pq.size() == 0 ? 0 : pq.peek();
    }
}