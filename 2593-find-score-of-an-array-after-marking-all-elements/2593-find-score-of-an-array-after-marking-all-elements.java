class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> {
                if(nums[a] != nums[b]) return Integer.compare(nums[a],nums[b]);
                return Integer.compare(a,b);
            }
        );

        for(int i=0;i<n;i++){
            pq.add(i);
        }

        boolean[] seen = new boolean[n];
        long score = 0;
        while(pq.size() > 0){
            int idx = pq.remove();
            int num = nums[idx];
            if(seen[idx]) continue;
            score += num;
            int lidx = idx-1;
            int ridx = idx+1;
            if(lidx >= 0) seen[lidx] = true;
            if(ridx < n) seen[ridx] = true;
        }
        return score;
    }
}