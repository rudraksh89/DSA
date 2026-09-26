class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> mp = new HashMap<>();
        for(List<String> l : knowledge){
            mp.put(l.get(0),l.get(1));
        }

        StringBuilder sb = new StringBuilder();
        boolean b = false;
        String bs = "";
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                b = true;
                continue;
            }else if(ch == ')'){
                if(mp.containsKey(bs)){
                    sb.append(mp.get(bs));
                }else sb.append('?');
                bs = "";
                b = false;
            }else{
                if(b){
                    bs += ch;
                }else sb.append(ch);
            }
        }
        return sb.toString();
    }
}