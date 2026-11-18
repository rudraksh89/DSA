class Solution {
    public int minChanges(String s) {
        int n = s.length();
        int count = 0;
        int i = 0;
        for(int j=1;j<n;j+=2){
            if(s.charAt(i) != s.charAt(j)) count++;
            i+=2;
        }
        return count;
    }
}