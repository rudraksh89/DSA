class Solution {

    int fn(int i, int j, int x, int[]piles, Integer[][][]dp){
        if(i > j) return 0;
        if(dp[i][j][x] != null) return dp[i][j][x];
        
        if(x == 1){
            int l = piles[i] + fn(i+1,j,0,piles,dp);
            int r = piles[j] + fn(i,j-1,0,piles,dp);
            return dp[i][j][x] = Math.max(l,r);
        }else{
            int l = -piles[i] + fn(i+1,j,1,piles,dp);
            int r = -piles[j] + fn(i,j-1,1,piles,dp);
            return dp[i][j][x] = Math.min(l,r);
        }
    }
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        Integer[][][] dp = new Integer[n][n][2];
        return fn(0,n-1,1,piles,dp) > 0;
    }
}