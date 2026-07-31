class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        int max = 0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1] - nums[i] == 1){
                int c = mp.get(nums[i]+1) + mp.get(nums[i]);
                max = Math.max(max,c);
            }
        }
        return max;
    }
}

