class Solution {

    static int fn(int idx, int amount, int[] coins, int[][]dp){
        if(idx == 0){
            return (amount % coins[0] == 0) ? 1 : 0;
        }
        

        if(dp[idx][amount] != -1) return dp[idx][amount];

        int nonpick = fn(idx-1,amount,coins,dp);
        int pick = 0;
        if(coins[idx] <= amount){
            pick = fn(idx,amount-coins[idx],coins,dp);
        }

        return dp[idx][amount] = pick + nonpick;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=amount;j++){
                dp[i][j] = -1;
            }
        }
        return fn(n-1,amount,coins,dp);
    }
 }