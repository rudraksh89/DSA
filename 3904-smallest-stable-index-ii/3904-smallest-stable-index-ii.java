class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] premax = new int[n];
        int[] suffmin = new int[n];
        int min = Integer.MAX_VALUE;
        premax[0] = nums[0];
        suffmin[n-1] = nums[n-1];
        for(int i=1;i<n;i++){
            premax[i] = Math.max(nums[i],premax[i-1]);
        }
        for(int i=n-2;i>=0;i--){
            suffmin[i] = Math.min(nums[i],suffmin[i+1]);
        }
        for(int i=0;i<n;i++){
            if(premax[i] - suffmin[i] <= k){
                min = i;
                break;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}