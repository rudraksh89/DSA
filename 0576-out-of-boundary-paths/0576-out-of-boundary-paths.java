class Solution {
    int mod = 1000000007;

    int fn(int i, int j, int m, int n, int maxMove, int[]di, int[]dj, int[][][]dp){
        if(i < 0 || j < 0 || i >= m || j >= n) return 1;
        if(maxMove == 0) return 0;
        if(dp[i][j][maxMove] != -1) return dp[i][j][maxMove];
        long ans = 0;
        for(int k=0;k<4;k++){
            int ni = i + di[k];
            int nj = j + dj[k];
            ans = (ans + fn(ni,nj,m,n,maxMove-1,di,dj,dp)) % mod;
        }
        return dp[i][j][maxMove] = (int)ans;
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int di[] = {0,0,-1,1};
        int dj[] = {-1,1,0,0};
        int[][][] dp = new int[m][n][maxMove+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }

        return fn(startRow,startColumn,m,n,maxMove,di,dj,dp);
    }
}