class Solution {

    public static void fn(int idx, int need, int n, String s, List<String> l){
        if(idx == n){
            if(need == 0){
                l.add(new String(s));
                return;
            }
            return;
        }
        fn(idx+1,need+1,n,s+'(',l);
        if(need > 0){
            fn(idx+1,need-1,n,s+')',l);
        }
        return;
    }
    public List<String> generateParenthesis(int n) {
        List<String> l = new ArrayList<>();
        fn(0,0,2*n,"",l);
        return l;
    }
}