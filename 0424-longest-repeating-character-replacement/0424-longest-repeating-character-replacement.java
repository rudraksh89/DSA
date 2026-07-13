class Solution {
    public int characterReplacement(String s, int k) {
        int a[] =new int[26];
        int l=0, r=0, maxfreq=0, maxlen=0;
        while(r<s.length()){
            a[s.charAt(r)-'A']++;
            maxfreq = Math.max(maxfreq,a[s.charAt(r)-'A']);
            if((r-l+1)-maxfreq >k){
                a[s.charAt(l)-'A']--;
                l++;
            }
            if((r-l+1)-maxfreq<=k){
                maxlen = Math.max(maxlen,r-l+1);
            }
            r++;
        }
        return maxlen;

    }
}