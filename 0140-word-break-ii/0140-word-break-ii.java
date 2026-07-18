class Solution {

    void fn(int idx, String s, HashSet<String>set, List<String> l, List<String> newl){
        int n = s.length();
        if(idx == n){
            String st = "";
            for(int i=0;i<newl.size();i++){
                st = st + newl.get(i);
                if(i != newl.size()-1){
                    st = st + " ";
                }
            }
            l.add(new String(st));
            return;
        }
        for(int i=idx;i<n;i++){
            String word = s.substring(idx,i+1);
            if(set.contains(word)){
                newl.add(word);
                fn(i+1,s,set,l,newl);
                newl.remove(newl.size()-1);
            }
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> l = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<wordDict.size();i++){
            set.add(wordDict.get(i));
        }
        fn(0,s,set,l,new ArrayList<>());
        return l;
    }
}