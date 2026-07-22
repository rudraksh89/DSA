class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int n = nums.length;
        int num = nums[n/2];
        HashMap<Integer,Integer> mp  = new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        return mp.get(num) == 1;
    }
}