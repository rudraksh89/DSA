class Solution {

    String booth(String s){
        int n = s.length();
        if(n <= 1) return s;
        int i=0;
        int j=1;
        int k=0;
        String t = s + s;
        while(i < n && j < n && k < n){
            char ch1 = t.charAt(i+k);
            char ch2 = t.charAt(j+k);
            if(ch1 == ch2){
                k++;
            }else if(ch1 > ch2){
                i = i + k +1;
                if (i <= j) i = j + 1;
                k = 0;
            }else {
                j = j + k + 1;
                if(j <= i) j = i + 1;
                k = 0;
            }
            
        }
        int st = Math.min(i,j);
        return t.substring(st,st+n);
    }
    public int minimumGroups(String[] words) {
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<words.length;i++){
            String str = words[i];
            StringBuilder even = new StringBuilder();
            StringBuilder odd = new StringBuilder();
            for(int j=0;j<str.length();j++){
                if(j % 2 == 0){
                    even.append(str.charAt(j));
                }else odd.append(str.charAt(j));


            }
            String s = booth(even.toString()) + "&" + booth(odd.toString());
            set.add(s);
        }
        return set.size();
    }
}