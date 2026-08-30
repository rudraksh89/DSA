class Solution {
    public int minimumDeletions(int[] nums) {
        int minidx = -1;
        int maxidx = -1;
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i] > max){
                max = nums[i];
                maxidx = i;
            }
            if(nums[i] < min){
                min = nums[i];
                minidx = i;
            }
        }

        int first = Math.max(maxidx,minidx)+1;
        int second = n - Math.min(maxidx, minidx);
        int third = Math.min(maxidx,minidx) + 1 + (n - Math.max(maxidx,minidx));
        return Math.min(first,Math.min(second,third));

        


    }
}