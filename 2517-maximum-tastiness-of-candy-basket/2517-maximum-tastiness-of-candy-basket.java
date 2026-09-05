class Solution {

    boolean fn(int[]price, int k, int mid){
        int c = 1;
        int pre = price[0];
        for(int i=1;i<price.length;i++){
            if(price[i] - pre >= mid){
                c++;
                pre = price[i];
            }
            if(c == k) return true;
        }
        return false;
    }
    public int maximumTastiness(int[] price, int k) {
        //can i have x tastiness in k distinct buckets ??
        int n = price.length;
        Arrays.sort(price);
        int l = 1;
        int r = price[n-1] - price[0];
        int ans = 0;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(fn(price,k,mid)){
                ans = mid;
                l = mid + 1;
            }else r = mid - 1;
        }
        return ans;
    }
}

// 1 2 5 8 13 21 