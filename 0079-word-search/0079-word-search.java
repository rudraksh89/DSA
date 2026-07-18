class Solution {

    public static boolean fn(int i, int j, int idx, char[][] board, String word, int[] di, int[] dj, int[][] visit){
        int n = board.length;
        int m = board[0].length;
        int len = word.length();
        if(idx == len) return true;
        if(i<0 || j<0 || i>=n || j>=m || visit[i][j] == 1 || board[i][j]!=word.charAt(idx)) return false;

        visit[i][j] = 1;
        for(int k=0;k<4;k++){
            int ni = i + di[k];
            int nj = j + dj[k];
            if(fn(ni,nj,idx+1,board,word,di,dj,visit)) return true;
        }
        visit[i][j] = 0;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        int[] di = {+1,0,0,-1};
        int[] dj = {0,-1,+1,0};
        int[][] visit = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == word.charAt(0) && fn(i,j,0,board,word,di,dj,visit)) return true;
            }
        }
        return false;
    }
}

