class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int n = lights.length;
        Arrays.sort(lights);
        int max = lights[n-1];
        int res = 0;
        for(int i=0;i<arrivalTime.length;i++){
            int r = arrivalTime[i] % period;
            int ans = 0;
            if(r < max)  ans = 0;
            else ans = period - r;
            res = Math.max(res,ans);
        }
        return res;
    }
}