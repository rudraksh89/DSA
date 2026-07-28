class Solution {

    int fn(int i, int j, List<Integer> l, int[][] dp){
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int min = (int)1e9;
        for(int idx=i;idx<=j;idx++){
            int count = (l.get(j+1) - l.get(i-1)) + fn(i,idx-1,l,dp) + fn(idx+1,j,l,dp);
            min = Math.min(min,count);
        }
        return dp[i][j] = min;
    }
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        ArrayList<Integer> l = new ArrayList<>();
        l.add(0);
        for(int i=0;i<cuts.length;i++){
            l.add(cuts[i]);
        }
        l.add(n);
        int [][] dp = new int[cuts.length+1][cuts.length+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return fn(1,cuts.length,l,dp);
    }
}