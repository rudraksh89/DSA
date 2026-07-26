class Solution {
    public int largestInteger(int n, int s) {
        if(9*n < s) return -1;
        if(s == 0) return 0;
        StringBuilder sb = new StringBuilder();
        while(n-- > 0){
            if(s >= 9){
                sb.append(9);
                s -= 9;
            }
            else{
                sb.append(s);
                s = 0;
            }
        }
        String st = sb.toString();
        int num = Integer.parseInt(st);
        return num;
    }
}