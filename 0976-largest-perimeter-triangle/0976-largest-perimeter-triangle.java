class Solution {
    public int largestPerimeter(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);
        int i = n-3;
        int j = n-2;
        int k = n-1;
        int ans = 0;
        while(i >=0){
            if(nums[i] + nums[j] > nums[k]){
                ans = nums[i] + nums[j] + nums[k];
                break;
            }
            i--;
            j--;
            k--;
        }
        return ans;

    }
}

