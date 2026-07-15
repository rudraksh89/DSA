class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int n = s.length();
        long ans = 0;
        while(i < n && s.charAt(i) == ' ') i++;
        if(i == n) return 0;

        int sign = 1;
        if(s.charAt(i) == '+' || s.charAt(i) == '-'){
            if(s.charAt(i) == '-') sign = -1;
            i++;
        }

        while(i < n && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i) - '0';
            ans = ans * 10 + digit;
            if(sign * ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(sign * ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;
        }
        return (int)ans*sign;
    }
}