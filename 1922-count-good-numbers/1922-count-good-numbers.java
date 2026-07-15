class Solution {

    long mod = 1000000007;
    long power(long base, long exp){
        if(exp == 0) return 1;
        long half = power(base,exp/2);
        long result = (half * half) % mod;
        if(exp % 2 == 1){
            result = (result * base) % mod;
        }
        return result;
    }
    public int countGoodNumbers(long n) {
        long even = (n+1)/2;
        long odd = n/2;
        long ans = (power(5,even) * power(4,odd) ) % mod;
        return (int)ans;
    }
}