class Solution {

    void fn(int idx, int n, List<String> l, String str){
        if(idx == n){
            l.add(new String(str));
            return;
        }
        fn(idx+1,n,l,str+"1");
        if(idx == 0 || str.charAt(idx-1) != '0'){
            fn(idx+1,n,l,str+"0");
        }
        return;
    }

    public List<String> validStrings(int n) {
        List<String> l = new ArrayList<>();
        fn(0,n,l,"");
        return l;
    }
}