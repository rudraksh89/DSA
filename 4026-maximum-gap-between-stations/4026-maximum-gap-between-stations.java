class Solution {
    public int maximumGap(String skill, String station) {
        int n = skill.length();
        int m = station.length();
        int[] l = new int[n];
        int[] r = new int[n];
        int j = 0;
        for(int i=0;i<n;i++){
            while(skill.charAt(i) != station.charAt(j)){
                j++;
            }
            l[i] = j;
            j++;
        }
        j = m-1;
        for(int i=n-1;i>=0;i--){
            while(skill.charAt(i) != station.charAt(j)){
                j--;
            }
            r[i] = j;
            j--;
        }
        int max = 0;

        for(int i=1;i<n;i++){
            int diff = r[i] - l[i-1];
            max = Math.max(max,diff);
        }
        return max;
    }
}

