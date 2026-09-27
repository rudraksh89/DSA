class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        Queue<Character>  q = new LinkedList<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == ')'){
                while(true){
                    char top = st.pop();
                    if(top != '(') q.offer(top);
                    else break;
                }
                while(!q.isEmpty()){
                    st.push(q.poll());
                }
            }else{
                st.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}