class Solution {
    int max(int num){
        int c = Integer.MIN_VALUE;
        while(num > 0){
            int rem = num % 10;
            if(c < rem) c = rem;
            num = num / 10;
        }
        return c;
    }

    int min(int num){
        int c = Integer.MAX_VALUE;
        while(num > 0){
            int rem = num % 10;
            if(c > rem) c = rem;
            num = num / 10;
        }
        return c;
    }
    
    public int maxDigitRange(int[] nums) {
        int[] dr = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            dr[i] = max(nums[i]) - min(nums[i]);
        }
        int maxele = Integer.MIN_VALUE;
        for(int i=0;i<dr.length;i++){
            if(maxele < dr[i]) maxele = dr[i];
        }
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            if(dr[i] == maxele) sum += nums[i];
        }
        return sum;
    }
}