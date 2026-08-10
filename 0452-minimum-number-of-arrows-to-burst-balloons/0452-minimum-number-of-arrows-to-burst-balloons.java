class Solution {

    class XY implements Comparable<XY>{
        int st;
        int en;
        XY(int st, int en){
            this.st = st;
            this.en = en;
        }
        public int compareTo(XY p){
            return Integer.compare(this.en,p.en);
        }
    }
    public int findMinArrowShots(int[][] points) {
        XY[] arr = new XY[points.length];
        for(int i=0;i<points.length;i++){
            arr[i] = new XY(points[i][0],points[i][1]);
        }
        Arrays.sort(arr);
        int c = 1;
        int last = arr[0].en;
        for(int i=1;i<points.length;i++){
            if(last < arr[i].st){
                c++;
                last = arr[i].en;
            }
        }
        return c;
    }
}