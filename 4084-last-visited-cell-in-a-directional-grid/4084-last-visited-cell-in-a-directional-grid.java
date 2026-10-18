class Solution {

    static int row;
    static int col;

    void fn(int i, int j, boolean[][] vis, char[][] grid){
        int m = grid.length; //1
        int n = grid[0].length; //3
        if(i < 0 || j < 0 || i >= m || j >= n || vis[i][j]){
            return;
        }

        row = i;
        col = j;
        vis[i][j] = true;
        if(grid[i][j] == 'L') fn(i,j-1,vis,grid);
        else if(grid[i][j] == 'R') fn(i,j+1,vis,grid);
        else if(grid[i][j] == 'U') fn(i-1,j,vis,grid);
        else fn(i+1,j,vis,grid);

    }
    public int[] lastVisitedCell(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        row = 0;
        col = 0;
        boolean[][] vis = new boolean[m][n];
        fn(0,0,vis,grid);
        return new int[]{row,col};
    }
}
// r d 
// u l

// r r r []