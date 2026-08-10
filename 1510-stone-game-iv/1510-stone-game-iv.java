class Solution {

    int fn(int idx, int chance, int n, int[][]dp) {
        if (idx == 0) {
            return chance == 1 ? 0 : 1;
        }
        if(dp[idx][chance] != -1) return dp[idx][chance];

        if (chance == 1) { 
            int ans = 0;
            for (int i = 1; i * i <= idx; i++) {
                int next = idx - i * i;
                int result = fn(next, 0, n, dp);
                ans = Math.max(ans, result);
            }
            return dp[idx][chance] = ans;
        } else {
            int ans = 1;
            for (int i = 1; i * i <= idx; i++) {
                int next = idx - i * i;
                int result = fn(next, 1, n, dp);
                ans = Math.min(ans, result);
            }
            return dp[idx][chance] = ans;
        }
    }

    public boolean winnerSquareGame(int n) {
        int[][] dp = new int[n+1][2];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return fn(n, 1, n, dp) == 1;
    }
}