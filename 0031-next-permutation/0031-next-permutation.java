class Solution {

    void rev(int st, int en, int[]nums){
        while(st <= en){
            int temp = nums[st];
            nums[st] = nums[en];
            nums[en] = temp;
            st++;
            en--;
        }
        return;
    }

    public void nextPermutation(int[] nums) {
        int bp = -1;
        int n = nums.length;
        for(int i=n-2;i>=0;i--){
            if(nums[i] < nums[i+1]){
                bp = i;
                break;
            }
        }

        if(bp == -1){
            rev(0,n-1,nums);
            return;
        }

        for(int j=n-1;j>=bp;j--){
            if(nums[j] > nums[bp]){
                int temp = nums[j];
                nums[j] = nums[bp];
                nums[bp] = temp;
                break;
            }
        }
        rev(bp+1,n-1,nums);
        return;
    }
}