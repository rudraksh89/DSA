class Solution {

    int fn(int i, int j, int x, int[]nums, Integer[][][]dp){
        if(i > j) return 0;
        if(dp[i][j][x] != null) return dp[i][j][x];
        if(x == 1){
            int l = nums[i] + fn(i+1,j,0,nums,dp);
            int r = nums[j] + fn(i,j-1,0,nums,dp);
            return dp[i][j][x] = Math.max(l,r);
        }else{
            int l = -nums[i] + fn(i+1,j,1,nums,dp);
            int r = -nums[j] + fn(i,j-1,1,nums,dp);
            return dp[i][j][x] = Math.min(l,r);
        }

    }
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        Integer[][][] dp = new Integer[n][n][2];
        return fn(0,n-1,1,nums,dp) >= 0;
    }
}