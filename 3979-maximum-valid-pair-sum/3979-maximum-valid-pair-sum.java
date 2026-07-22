class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int n = nums.length;
        int premx = Integer.MIN_VALUE;
        int i = 0;
        int j = k;
        int ans = 0;
        while(j < n){
            premx = Math.max(premx,nums[i]);
            int sum = nums[j] + premx;
            ans = Math.max(ans,sum);
            i++;
            j++;
        }
        return ans;
        
    }
}