// class Solution {

//     int ans = Integer.MAX_VALUE;
//     void fn(int i, int j, int n, int m, int[] dr, int[]dc, boolean[][]vis, int moves){
//         if(i < 0 || j < 0 || i >= 8 || j >= 8 || vis[i][j]) return;
//         if (moves >= ans) return;
//         if(i == n && j == m){
//             ans = Math.min(ans,moves);
//             return;
//         }
//         vis[i][j] = true;
//         for(int k=0;k<8;k++){
//             int ni = i + dr[k];
//             int nj = j + dc[k];
//             fn(ni,nj,n,m,dr,dc,vis,moves+1);
//         }
//         vis[i][j] = false;
//     }
//     public boolean canReach(int[] start, int[] target) {
//         int[] dr = {-1,-2,-2,-1,1,2,2,1};
//         int[] dc = {-2,-1,1,2,2,1,-1,-2};
//         boolean[][] vis = new boolean[8][8];
//         fn(start[0],start[1],target[0],target[1],dr,dc,vis,0);
//         return ans % 2 == 0;
//     }
// }

class Solution {
    public boolean canReach(int[] start, int[] target) {
        return ((start[0] + start[1]) % 2)
            == ((target[0] + target[1]) % 2);
    }
}