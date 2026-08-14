class Solution {
    public int maximumLengthSubstring(String s) {
        int l = 0;
        int max = 0;
        HashMap<Character,Integer> mp = new HashMap<>();
        for(int r=0;r<s.length();r++){
            char c = s.charAt(r);
            mp.put(c,mp.getOrDefault(c,0)+1);
            while(mp.get(c) > 2){
                char ch = s.charAt(l);
                mp.put(ch,mp.get(ch)-1);
                if(mp.get(ch) == 0) mp.remove(ch);
                l++;
            }
            max = Math.max(max,r-l+1);
        }
        return max;
    }
}