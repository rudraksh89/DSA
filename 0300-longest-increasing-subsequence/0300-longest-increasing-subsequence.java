class Solution {

    int fn(int idx, int prev, int[]nums, int[][]dp){
        if(idx == nums.length) return 0;
        if(dp[idx][prev+1] != -1) return dp[idx][prev+1];
        int take = 0;
        if(prev == -1 || nums[idx] > nums[prev]){
            take = 1 + fn(idx+1,idx,nums,dp);
        }
        int nontake = fn(idx+1,prev,nums,dp);
        return dp[idx][prev+1] = Math.max(take,nontake);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return fn(0,-1,nums,dp);
    }
}