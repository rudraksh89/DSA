class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        int st = intervals[0][0];
        int en = intervals[0][1];
        List<int[]> l = new ArrayList<>();
        for(int i=1;i<intervals.length;i++){
            if(en < intervals[i][0]){
                l.add(new int[]{st,en});
                st = intervals[i][0];
                en = intervals[i][1];
            }else{
                en = Math.max(intervals[i][1],en);
            }
        }
        l.add(new int[]{st,en});
        return l.toArray(new int[l.size()][]);
    }
}