class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        List<List<Integer>> l = new ArrayList<>();
        int n1 = series1.length;
        int n2 = series2.length;
        int i = 0;
        int j = 0;
        while(i < n1 || j < n2){
            int t1 = (i < n1) ? series1[i][0] : Integer.MAX_VALUE;
            int t2 = (j < n2) ? series2[j][0] : Integer.MAX_VALUE;
            int val1 = (i < n1) ? series1[i][1] : 0;
            int val2 = (j < n2) ? series2[j][1] : 0;
            int stamp = Math.min(t1,t2);
            int sum = val1 + val2;
            l.add(Arrays.asList(stamp,sum));
            if (i < n1 && series1[i][0] == stamp) i++;
            if (j < n2 && series2[j][0] == stamp) j++;
        }
        return l;
    }
}