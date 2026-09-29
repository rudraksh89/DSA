class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {
        int n = nums.length;
        int pre = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1]) pre++; 
        }
        HashMap<String,Integer> mp = new HashMap<>();
        int max = 0;
        for(int i=1;i<n;i++){
            int a = nums[i-1];
            int b = nums[i];
            if(a == b) continue;
            int f = Math.min(a,b);
            int s = Math.max(a,b);
            String str = f + "," + s;
            mp.put(str,mp.getOrDefault(str,0)+1);
            max = Math.max(max,mp.get(str));
        }
        return max + pre;
    }
}
