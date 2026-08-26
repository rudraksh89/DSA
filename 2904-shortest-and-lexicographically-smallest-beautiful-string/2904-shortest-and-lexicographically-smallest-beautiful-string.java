class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        List<String> l = new ArrayList<>();
        for(int i=0;i<n;i++){
            int one = 0;
            for(int j=i;j<n;j++){
                if(s.charAt(j) == '1') one++;
                if(one == k) l.add(s.substring(i,j+1));
                if(one > k) break; 
            }
        }
        if(l.size() == 0) return "";
        Collections.sort(l,(a,b)->{
            if(a.length() != b.length()) return a.length() - b.length();
            return a.compareTo(b);
        });

        return l.get(0);

    }
}