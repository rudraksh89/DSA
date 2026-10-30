class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> list = new ArrayList<>();
        int n = expression.length();

        for(int i=0;i<n;i++){
            char ch = expression.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                List<Integer> a = diffWaysToCompute(expression.substring(0,i));
                List<Integer> b = diffWaysToCompute(expression.substring(i+1));
                for(int x : a){
                    for(int y : b){
                        if(ch == '+') list.add(x+y);
                        else if(ch == '-') list.add(x-y);
                        else if(ch == '*') list.add(x*y);
                        else list.add(x/y);
                    }
                }
            }
        }
        if(list.size() == 0) list.add(Integer.valueOf(expression));
        return list;
    }
}