class Solution {

    int fn(int num){
        int[] digit = new int[10];
        while(num > 0){
            int rem = num % 10;
            digit[rem]++;
            num /= 10;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=9;i>=0;i--){
            while(digit[i] > 0){
                sb.append(i);
                digit[i]--;
            }
        }

        return Integer.parseInt(sb.toString());
    }
    public long maximizeSum(int[] nums, int k) {
        int n = nums.length;
        int[][] arr = new int[n][3];
        long sum = 0;
        for(int i=0;i<n;i++){
            arr[i][0] = nums[i];
            arr[i][1] = fn(nums[i]);
            arr[i][2] = arr[i][1] - arr[i][0];
            sum += nums[i];
        }

        Arrays.sort(arr,(a,b)->{
            return Integer.compare(b[2],a[2]);
        });

        for(int i=0;i<k;i++){
            sum += arr[i][1] - arr[i][0];
        }
        
        return sum;


        


    }
}