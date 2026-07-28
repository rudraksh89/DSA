class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int st = 0;
        int sum = 0;
        int total = 0;
        for(int i=0;i<gas.length;i++){
            int diff = gas[i] - cost[i];
            sum += diff;
            total += diff;
            if(sum < 0){
                sum = 0;
                st = i+1;
            }
        }
        return total >= 0 ? st : -1;
    }
}