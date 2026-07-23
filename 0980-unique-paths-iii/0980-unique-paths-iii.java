class Solution {

    int fn(int i, int j, int ti, int tj, int k, boolean[][] vis, int[][] grid, int[]di, int[]dj){
        int n = grid.length;
        int m = grid[0].length;
        if(i == ti && j == tj){
            return (k == 1) ? 1 : 0;
        }
        int ans  = 0;
        vis[i][j] = true;
        for(int p=0;p<4;p++){
            int ni = i + di[p];
            int nj = j + dj[p];
            if(ni >= 0 && nj >= 0 && ni < n && nj < m && !vis[ni][nj] && grid[ni][nj] != -1){
                ans += fn(ni,nj,ti,tj,k-1,vis,grid,di,dj);
            }
        }
        vis[i][j] = false;
        return ans;
    }


    public int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int obs = 0;
        int sti = 0;
        int stj = 0;
        int eni = 0;
        int enj = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == -1) obs++;
                if(grid[i][j] == 1){
                    sti = i;
                    stj = j;
                }
                if(grid[i][j] == 2){
                    eni = i;
                    enj = j;
                }
            }
        }
        int finalcount = (n*m) - obs;

        boolean[][] vis = new boolean[n][m];
        int[] di = {0,0,-1,1};
        int[] dj = {-1,1,0,0};
        return fn(sti, stj, eni, enj, finalcount, vis, grid, di, dj);
        
    }
}