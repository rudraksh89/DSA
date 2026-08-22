// class Solution {
//     public int maximumPopulation(int[][] logs) {
//         int[] dat = new int[2051];
//         for(int[] row : logs){
//             int live = row[0];
//             int dead = row[1];
//             dat[live] += 1;
//             dat[dead] -= 1;
//         }
//         int min = 2051;
//         int curr = 0;
//         int mxpeople = 0;
//         for(int year=1950;year<2051;year++){
//             curr += dat[year];
//             if(curr > mxpeople){
//                 mxpeople = curr;
//                 min = year;
//             }
//         }
//         return min;
//     }
// }

class Solution {
    public int maximumPopulation(int[][] logs) {
        int n = logs.length;
        List<int[]> l = new ArrayList<>();
        for(int[] row : logs){
            int birth = row[0];
            int dead = row[1];
            l.add(new int[]{birth,1});
            l.add(new int[]{dead,-1});
        }

        Collections.sort(l,(a,b)->{
            if(a[0] == b[0]) return a[1] - b[1];
            else return a[0] - b[0];
        });

        int min = 0;
        int curr = 0;
        int max = 0;
        for(int[] e : l){
            curr += e[1];
            if(curr > max){
                max = curr;
                min = e[0];
            }
        }
        return min;

    }
}