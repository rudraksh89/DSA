class Solution {

    boolean fn(int[]position, int m, int x){
        int n = position.length;
        int c = 1;
        int last = position[0];
        for(int i=1;i<n;i++){
            if(position[i] - last >= x){
                c++;
                last = position[i];
            }
            if(c == m) return true;
        }
        return false;
    }
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);
        int l = 0;
        int r = position[n-1] - position[0];
        int ans = 0;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(fn(position,m,mid)){
                ans = mid;
                l = mid + 1;
            }else r = mid - 1;
        }
        return ans;
    }
}