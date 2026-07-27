class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        int max = 0;
        int maxc = 0;
        for(int i=0;i<n;i++){
            dp[i] = 1;
            cnt[i] = 1;
            for(int j=0;j<=i;j++){
                if(nums[i] > nums[j] && 1+dp[j] > dp[i]){
                    dp[i] = 1 + dp[j];
                    cnt[i] = cnt[j];
                }else if(nums[i] > nums[j] && 1+dp[j] == dp[i]) cnt[i] += cnt[j];
            }
            max = Math.max(max,dp[i]);
        }
        for(int i=0;i<n;i++){
            if(dp[i] == max) maxc += cnt[i];
        }
        return maxc;
    }
}