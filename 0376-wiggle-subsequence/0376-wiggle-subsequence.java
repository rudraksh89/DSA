class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if(n < 2) return 1;
        int count = 1;
        int prev = 0;
        for(int i=1;i<n;i++){
            int diff = nums[i] - nums[i-1];
            if((diff > 0 && prev <= 0 ) || (diff < 0 && prev >= 0)){
                count++;
                prev = diff;
            }
        }
        return count;
    }
}