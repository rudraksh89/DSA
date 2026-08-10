class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);
        int n = prices.length;
        int m = discounts.length;
        int i = n-1;
        int j = m-1;
        double res = 0;
        while(i >= 0){
            if(j >= 0){
                double ans = (prices[i] * (100 - discounts[j]) / 100.0);
                res += ans;
                j--;
            }
            else res += prices[i];
            i--;
        }
        return res;
    }
}