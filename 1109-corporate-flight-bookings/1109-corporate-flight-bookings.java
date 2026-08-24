class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {

        int[] arr = new int[n+2];
        for(int[] row : bookings){
            arr[row[0]] += row[2];
            arr[row[1]+1] -= row[2];
        }
        for(int i=1;i<arr.length;i++){
            arr[i] = arr[i] + arr[i-1];
        }
        int[] ans = new int[n];
        for(int i=1;i<=n;i++){
            ans[i-1] = arr[i];
        }
        return ans;
    }
}