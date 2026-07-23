class Solution {

    int fn(int idx, int[]nums, int[]dp){
        if(idx < 0) return 0;
        if(idx == 0) return nums[0];
        if(dp[idx] != -1) return dp[idx];
        int take = 0;
        if(idx >= 1) take = nums[idx] + fn(idx-2,nums,dp);
        int nontake = fn(idx-1,nums,dp);
        return dp[idx] = Math.max(take,nontake);

    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return fn(n-1,nums,dp);
    }
}