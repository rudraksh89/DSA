class Solution {
    public String removeDuplicateLetters(String s) {
        int[] fre = new int[26];
        boolean[] seen = new boolean[26];
        Stack<Character> st = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            fre[ch-'a']++;
        }

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            fre[c-'a']--;
            if(seen[c-'a'] == true) continue;
            if(st.size() == 0){
                st.push(c);
                seen[c - 'a'] = true;
                continue;
            }
            else{
                while(st.size()>0 && c < st.peek() && fre[st.peek() - 'a'] > 0){
                    seen[st.peek()-'a'] = false;
                    st.pop();
                }
                st.push(c);
                seen[c - 'a'] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : st) sb.append(c);
        return sb.toString();

    }
}