class Solution {

    void reverse(int[]nums, int st, int en){
        while(st <= en){
            int temp = nums[st];
            nums[st] = nums[en];
            nums[en] = temp;
            st++;
            en--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        reverse(nums,0,n-k-1);
        reverse(nums,n-k,n-1);
        reverse(nums,0,n-1);
        return;
    }
}