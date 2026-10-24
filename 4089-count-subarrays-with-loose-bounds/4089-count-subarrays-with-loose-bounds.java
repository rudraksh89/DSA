class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;
        int l = 0;
        int r = 0;
        while(r < nums.length){
            while(r < nums.length && (nums[r] > maxK || nums[r] < minK)){
                r++;
                l = r;
            }
            if(r < nums.length && (nums[r] >= minK && nums[r] <= maxK)){
                count += r-l+1;
                r++;
            }
        }
        return count;
    }
}