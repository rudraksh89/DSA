class Solution {

    int[] dr = {-2,-2,-1,-1,1,1,2,2};
    int[] dc = {-1,1,-2,2,-2,2,-1,1};
    int mod = 1000000007;

    int fn(int i, int j, int n, int[][]board, int[][][]dp){
        int p = board.length;
        int q = board[0].length;
        if(n == 0) return 1;
        if(dp[i][j][n] != -1) return dp[i][j][n];
        long ans = 0;
        for(int k=0;k<8;k++){
            int nr = i + dr[k];
            int nc = j + dc[k];
            if(nr >= 0 && nc >= 0 && nr < p && nc < q && board[nr][nc] != -1){
                ans = (ans + fn(nr,nc,n-1,board,dp)) % mod;
            }
        }
        return dp[i][j][n] = (int)ans;
    }
    public int knightDialer(int n) {
        int[][] board = {
            {1,2,3},
            {4,5,6},
            {7,8,9},
            {-1,0,-1}
        };

        int res = 0;
        int[][][] dp = new int[4][3][n];
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }

        int p = board.length;
        int q = board[0].length;
        for(int i=0;i<p;i++){
            for(int j=0;j<q;j++){
                if(board[i][j] == -1) continue;
                res = (res + fn(i, j, n-1, board,dp)) % mod;
            }
        }
        return res;

    }
}