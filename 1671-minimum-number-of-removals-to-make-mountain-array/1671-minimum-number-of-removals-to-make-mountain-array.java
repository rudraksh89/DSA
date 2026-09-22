class Solution {
    public int minimumMountainRemovals(int[] arr) {
        int n = arr.length;
        int[] lis = new int[n];
        int[] lds = new int[n];
        
        for(int i=0;i<n;i++){
            lis[i] = 1;
            for(int j=0;j<i;j++){
                if(arr[i] > arr[j]){
                    lis[i] = Math.max(lis[i],1+lis[j]);
                }
            }
        }

        for(int i=n-1;i>=0;i--){
            lds[i] = 1;
            for(int j=n-1;j>i;j--){
                if(arr[i] > arr[j]){
                    lds[i] = Math.max(lds[i],1+lds[j]);
                }
            }
        }

        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            if(lis[i] > 1 && lds[i] > 1) nums[i] = lis[i] + lds[i] - 1;
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min = Math.min(min,n-nums[i]);
        }
        return min;
    }
}