class Solution {
    public int countConsistent(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i=0;i<n;i++){
            int min = Integer.MAX_VALUE;
            int a = 1;
            for(int j=i;j<n;j++){
                min = Math.min(min,nums[j]);
                a = (j-i+1 == 1) ? a = nums[j] : a & nums[j];
                if(min == a) count++;
            }
        }
        return count;
    }
}