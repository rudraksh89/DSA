class Solution {

    int fn(int i, int j, int n, int m, int[][] grid, int[][]dp){
        if(i >= n || j >= m) return (int)1e9;
        if(i == n-1 && j == m-1) return grid[i][j];
        if(dp[i][j] != -1) return dp[i][j];
        int left = grid[i][j] + fn(i,j+1,n,m,grid,dp);
        int right = grid[i][j] + fn(i+1,j,n,m,grid,dp);
        return dp[i][j] = Math.min(left,right);
    }
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return fn(0,0,n,m,grid,dp);
    }
}