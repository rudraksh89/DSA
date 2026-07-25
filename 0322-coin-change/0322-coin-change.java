class Solution {

    int fn(int idx, int k, int[]coins, int[][]dp){
        if(idx == 0){
            if(k % coins[0] == 0) return k/coins[0];
            else return (int)1e9;
        }
        if(dp[idx][k] != -1) return dp[idx][k];
        int nonpick = fn(idx-1,k,coins,dp);
        int pick = (int)1e9;
        if(k >= coins[idx]){
            pick = 1 + fn(idx,k-coins[idx],coins,dp);
        }
        return dp[idx][k] = Math.min(pick,nonpick);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        int ans = fn(n-1,amount,coins,dp);
        return (ans>=(int)1e9)? -1 : ans; 
    }
}