class Solution {
    public int longestSubarray(int[] nums, int k) {
        int[] spf = new int[1000001];
        int[] freq = new int[1000001];
        int l = 0;
        int dist = 0;
        int res = 0;

        for(int i=0;i<=100000;i++){
            spf[i] = i;
        }
        for(int i=2;i*i<=100000;i++){
            if(spf[i] == i){
                for(int j=i*i;j<=100000;j+=i){
                    if(spf[j] == j) spf[j] = i; 
                }
            }
        }

        for(int r=0;r<nums.length;r++){
            int num = nums[r];
            while(num > 1){
                int p = spf[num];
                if(freq[p] == 0) dist++;
                freq[p]++;
                while(num % p == 0){
                    num /= p;
                }
            }

            while(dist > k){
                int left = nums[l];
                while(left > 1){
                    int p = spf[left];
                    freq[p]--;
                    if(freq[p] == 0) dist--;
                    while(left % p ==0){
                        left /= p;
                    }
                }
                l++;
            }
            res = Math.max(res,r-l+1);
        }
        return res;
    }
}