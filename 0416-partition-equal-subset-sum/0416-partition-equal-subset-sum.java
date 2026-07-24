class Solution {

    boolean fn(int idx, int sum, int[]nums, int[][] dp){
        if(idx == nums.length){
            if(sum == 0) return true;
            else return false;
        }
        if(dp[idx][sum] != -1) return dp[idx][sum] == 1;
        boolean pick = false;
        if(sum >= nums[idx]){
            pick = fn(idx+1,sum-nums[idx],nums,dp);
        }
        boolean nonpick = fn(idx+1,sum,nums,dp);
        boolean ans = pick || nonpick;
        dp[idx][sum] = ans ? 1 : 0;
        return ans;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        if(sum % 2 == 1) return false;
        int [][] dp = new int[n][sum/2 + 1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return fn(0,sum/2,nums,dp);
    }
}