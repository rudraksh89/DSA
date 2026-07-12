class Solution {
    
    int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nse = new int[n];
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(st.size() > 0 && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.size() == 0) nse[i] = n;
            else nse[i] = st.peek();
            st.push(i);
        }
        st.clear();

        for(int i=0;i<n;i++){
            while(st.size() > 0 && heights[st.peek()] > heights[i]){
                st.pop();
            }
            if(st.size() == 0) pse[i] = -1;
            else pse[i] = st.peek();
            st.push(i);
        }

        int max = 0;
        for(int i=0;i<n;i++){
            int l = heights[i];
            int b = nse[i] - pse[i] - 1;
            int area = l * b;
            max = Math.max(max,area);
        }
        return max;
    }


    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] heights = new int[m];
        int ans = 0;
        
         for (char[] row : matrix) {
            for (int j = 0; j < m; j++) {
                if (row[j] == '1') heights[j]++;
                else  heights[j] = 0;
            }
            ans = Math.max(ans, largestRectangleArea(heights));
        }
        return ans;
    }
}