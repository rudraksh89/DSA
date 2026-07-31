class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum += nums.get(j);
                if((j-i+1) >= l && (j-i+1) <= r && sum > 0){
                    min = Math.min(min,sum);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}

// 5 8 -6
// l = 1
// r = 3
