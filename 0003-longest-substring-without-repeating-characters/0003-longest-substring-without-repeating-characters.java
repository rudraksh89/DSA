class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> mp = new HashMap<>();
        int l = 0;
        int r = 0;
        int n = s.length();
        int max = 0;
        while(r < n){
            char ch = s.charAt(r);
            if(mp.containsKey(ch)){
                while(mp.containsKey(ch)){
                    mp.remove(s.charAt(l));
                    l++;
                }
            }
            mp.put(ch,1);
            max = Math.max(max,r-l+1);
            r++;
        }
        return max;
        
    }
}