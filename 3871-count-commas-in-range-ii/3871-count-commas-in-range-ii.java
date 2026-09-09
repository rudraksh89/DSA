class Solution {
    public long countCommas(long n) {
        long ans = 0;
        if (n >= 1000) {
            long r = Math.min(n, 999999L);
            ans += (r - 1000 + 1) * 1;
        }
        if (n >= 1000000) {
            long r = Math.min(n, 999999999L);
            ans += (r - 1000000 + 1) * 2;
        }
        if (n >= 1000000000) {
            long r = Math.min(n, 999999999999L);
            ans += (r - 1000000000 + 1) * 3;
        }
        if (n >= 1000000000000L) {
            long r = Math.min(n, 1000000000000000L);
            ans += (r - 1000000000000L + 1) * 4;
        }
        if (n >= 1000000000000000L) {
            ans += 1;
        }
        return ans;
    }
}