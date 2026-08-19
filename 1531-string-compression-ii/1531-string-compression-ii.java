// class Solution {

//     HashMap<String, Integer> dp = new HashMap<>();
//     int com(String s){
//         String ans = "";
//         int n = s.length();
//         int l = 0;
//         int r = 0;
//         while(r < n){
//             int count = 0;
//             while(r < n && s.charAt(l) == s.charAt(r)){
//                 r++;
//                 count++;
//             }
//             ans = ans + s.charAt(l);
//             if(count > 1){
//                 String sb = String.valueOf(count);
//                 for(int i=0;i<sb.length();i++){
//                     ans = ans + sb.charAt(i);
//                 }
//             }
//             l = r;
//         }
//         return ans.length();
//     }

//     int fn(int idx, int k, String s, String str){
//         if(idx == s.length()){
//             return com(str);
//         }
//         String key = idx + "$" + k + "$" + str;
//         if(dp.containsKey(key)) return dp.get(key);
//         int pick = fn(idx+1,k,s,str+s.charAt(idx));
//         int nonpick = Integer.MAX_VALUE;
//         if(k > 0){
//             nonpick = fn(idx+1,k-1,s,str);
//         }
//         int ans = Math.min(pick,nonpick);
//         dp.put(key,ans);
//         return ans;
//     }
//     public int getLengthOfOptimalCompression(String s, int k) {
//         int n = s.length();
//         return fn(0,k,s,"");
//     }
// }


class Solution {

    int fn(int idx, int k, int last, int count, String s, int[][][][]dp){
        if(idx == s.length()) return 0;
        if(dp[idx][k][last][count] != -1) return dp[idx][k][last][count];

        int nonpick = Integer.MAX_VALUE;
        if(k > 0){
            nonpick = fn(idx+1,k-1,last,count,s,dp);
        }
        int pick;
        int curr = s.charAt(idx) - 'a';
        if(curr == last){
            int num = 0;
            if(count==1 || count==9 || count==99) num = 1;
            pick = num + fn(idx+1,k,last,count+1,s,dp);
        }else{
            pick = 1 + fn(idx+1,k,curr,1,s,dp);
        }
        return dp[idx][k][last][count] = Math.min(pick,nonpick);
    }
    public int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();
        int[][][][] dp = new int[n][k+1][27][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<=k;j++){
                for(int p=0;p<27;p++){
                    Arrays.fill(dp[i][j][p],-1);
                }
            }
        }
        return fn(0,k,26,0,s,dp);

    }
}