class Solution {

    static int mod = 1000000007;
    int fn(int i, int[] last, int[]dp){
        if(i < 0) return 1;
        if(dp[i] != -1) return dp[i];
        long total = (2L * (fn(i-1,last,dp))) % mod;
        if(last[i] != -1){
            int dup = fn(last[i] - 1 ,last,dp);
            total = (total - dup + mod) % mod;
        }
        return dp[i] = (int)total;
    }
    public int distinctSubseqII(String s) {
        int n = s.length();
        int[] prev = new int[26];
        Arrays.fill(prev,-1);
        int[] last = new int[n];
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        for(int i=0;i<n;i++){
            int idx = s.charAt(i) - 'a';
            last[i] = prev[idx];
            prev[idx] = i;  
        }
        return (fn(n-1,last,dp)-1+mod) % mod;
    }
}