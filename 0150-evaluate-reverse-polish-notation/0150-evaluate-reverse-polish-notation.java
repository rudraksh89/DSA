class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int res = 0;
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
                int a = st.pop();
                int b = st.pop();
                if(tokens[i].equals("+")) st.push(b+a);
                else if(tokens[i].equals("-")) st.push(b-a);
                else if(tokens[i].equals("*")) st.push(b*a);
                else st.push(b/a);
            }else st.push(Integer.parseInt(tokens[i]));
        }
        return st.peek();   
    }
}