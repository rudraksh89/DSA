class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        int n = asteroids.length;
        for(int i=0;i<n;i++){
            if(asteroids[i] > 0){
                st.push(asteroids[i]);
            }else{
                int val = Math.abs(asteroids[i]);
                while(st.size() > 0 && st.peek() > 0 && val > st.peek()){
                    st.pop();
                }
                if(st.size() > 0 && val == st.peek()) st.pop();
                else if(st.size() == 0 || st.peek() < 0) st.push(-val);
            }
        }
        int k = st.size();
        int[] arr = new int[k];
        for(int i=k-1;i>=0;i--){
            arr[i] = st.pop();
        }
        return arr;
    }
}