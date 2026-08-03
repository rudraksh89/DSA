class Solution {
    public int countValidPrefixes(String s) {
        int o = 0;
        int z = 0;
        int ans = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '0') o++;
            else z++;
            if(Math.abs(z-o) <= 1) ans++;
        }
        return ans;
    }
}
