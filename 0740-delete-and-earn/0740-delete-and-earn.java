class Solution {

    int fn(int idx, int[]arr, int[]dp){
        if(idx >= arr.length) return 0;
        if(dp[idx] != -1) return dp[idx];
        int pick = arr[idx] + fn(idx+2,arr,dp);
        int nonpick = fn(idx+1,arr,dp);
        return dp[idx] = Math.max(pick,nonpick);
    }
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max,nums[i]);
        }
        int[] arr = new int[max+1];
        for(int e : nums){
            arr[e] += e;
        }
        int[] dp = new int[max+1];
        Arrays.fill(dp,-1);
        return fn(1,arr,dp);
    }
}