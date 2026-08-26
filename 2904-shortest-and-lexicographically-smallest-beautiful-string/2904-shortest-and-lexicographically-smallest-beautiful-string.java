// class Solution {
//     public String shortestBeautifulSubstring(String s, int k) {
//         int n = s.length();
//         List<String> l = new ArrayList<>();
//         for(int i=0;i<n;i++){
//             int one = 0;
//             for(int j=i;j<n;j++){
//                 if(s.charAt(j) == '1') one++;
//                 if(one == k) l.add(s.substring(i,j+1));
//                 if(one > k) break; 
//             }
//         }
//         if(l.size() == 0) return "";
//         Collections.sort(l,(a,b)->{
//             if(a.length() != b.length()) return a.length() - b.length();
//             return a.compareTo(b);
//         });

//         return l.get(0);

//     }
// }


class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int l = 0;
        int r = 0;
        int n = s.length();
        int ones = 0;
        String str = "";
        while(r < n){
            if(s.charAt(r) == '1') ones++;
            while(ones >= k){
                if(ones == k){
                    String curr = s.substring(l,r+1);
                    if(str.equals("") || str.length() > curr.length() || (str.length() == curr.length() && curr.compareTo(str) < 0)){
                        str = curr;
                    }
                }
                if(s.charAt(l) == '1') ones--;
                l++;
            }
            r++;
        }
        return str;
    }
}