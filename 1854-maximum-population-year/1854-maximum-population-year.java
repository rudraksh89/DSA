class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] dat = new int[2051];
        for(int[] row : logs){
            int live = row[0];
            int dead = row[1];
            dat[live] += 1;
            dat[dead] -= 1;
        }
        int min = 2051;
        int curr = 0;
        int mxpeople = 0;
        for(int year=1950;year<2051;year++){
            curr += dat[year];
            if(curr > mxpeople){
                mxpeople = curr;
                min = year;
            }
        }
        return min;
    }
}