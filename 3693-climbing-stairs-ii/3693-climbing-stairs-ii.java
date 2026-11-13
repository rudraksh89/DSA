class Solution {

    int fn(int idx, int n, int[]costs, int[]dp){
        if(idx >= n) return 0;
        if(dp[idx] != -1) return dp[idx];

        int a1 = Integer.MAX_VALUE;
        int a2 = Integer.MAX_VALUE;
        int a3 = Integer.MAX_VALUE;
        if(idx+1 <= n) a1 = costs[idx] + (idx+1-idx)*(idx+1-idx) + fn(idx+1,n,costs,dp);
        if(idx+2 <= n) a2 = costs[idx+1] + (idx+2-idx)*(idx+2-idx) + fn(idx+2,n,costs,dp);
        if(idx+3 <= n) a3 = costs[idx+2] + (idx+3-idx)*(idx+3-idx) + fn(idx+3,n,costs,dp);

        return dp[idx] = Math.min(a1,Math.min(a2,a3));
    }
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return fn(0,n,costs,dp);
    }
}