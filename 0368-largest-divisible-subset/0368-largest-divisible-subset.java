class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        int[] prev = new int[n];
        int max = 0;
        int index = -1;
        List<Integer> l = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            dp[i] = 1;
            prev[i] = -1;
            for(int j=0;j<i;j++){
                if(nums[i] % nums[j] == 0){
                    if(1 + dp[j] > dp[i]){
                        dp[i] = 1 + dp[j];
                        prev[i] = j;
                    }
                }
            }
            if(dp[i] > max){
                max = dp[i];
                index = i;
            }
        }
        while(index != -1){
            l.add(nums[index]);
            index = prev[index];
        }
        return l;
    }
}