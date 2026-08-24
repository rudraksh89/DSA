class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {

        //dat technique :)
        int n = nums.length;
        long sum = 0;
        int[] dat = new int[n+1];
        for(int[] row : requests){
            int st = row[0];
            int en = row[1];
            dat[st]++;
            dat[en+1]--;
        }
        for(int i=1;i<n;i++){
            dat[i] = dat[i] + dat[i-1];
        }
        Arrays.sort(dat,0,n);
        Arrays.sort(nums);

        for(int i=0;i<n;i++){
            sum += (long)nums[i] * dat[i];
        }
        return (int)(sum % 1000000007);
    }
}