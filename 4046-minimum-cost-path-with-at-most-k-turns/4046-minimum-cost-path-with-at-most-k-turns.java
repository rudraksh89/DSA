class Solution {

    int fn(int i, int j, int[][] grid, int k, int pre, int[][][][]dp){
        int n = grid.length;
        int m = grid[0].length;
        if(i == n-1 && j == m-1) return grid[i][j];
        if(dp[i][j][k][pre] != -1) return dp[i][j][k][pre];
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int ans = Integer.MAX_VALUE;

        for(int d=0;d<4;d++){
            int ni = i + dr[d];
            int nj = j + dc[d];
            if(ni <0 || ni >= n || nj <0 || nj >= m) continue;
            int dir = k;
            if(pre != 4 && pre != d) dir--;
            if(dir < 0) continue;
            int c = fn(ni,nj,grid,dir,d,dp);
            if(c != Integer.MAX_VALUE){
                ans = Math.min(ans,grid[i][j] + c);
            }
            
        }
        return dp[i][j][k][pre] = ans;
    }
    public int minCost(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][][] dp = new int[n][m][k+1][5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int t = 0; t <= k; t++) {
                     Arrays.fill(dp[i][j][t], -1);
               }
            }
        }
        int res = fn(0, 0, grid, k, 4, dp);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}