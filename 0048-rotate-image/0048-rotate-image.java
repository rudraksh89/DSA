class Solution {
    public static void transpose(int[][]matrix){
        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        return;
    }

    public static void rev(int[] nums){
        int n = nums.length;
        int st = 0;
        int en = n-1;
        while(st <= en){
            int temp = nums[st];
            nums[st] = nums[en];
            nums[en] = temp;
            st++;
            en--;
        }
        return;
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        transpose(matrix);
        for(int[] row : matrix){
            rev(row);
        }
        return;
    }
}
