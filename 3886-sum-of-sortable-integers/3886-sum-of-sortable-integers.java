class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;

        List<Integer> list = new ArrayList<>();
        for(int i=1;i*i<=n;i++){
            if(n % i == 0){
                list.add(i);
                if(i != n/i) list.add(n/i);
            }
        }


        for(int k : list){
            boolean flag = false;
            int prev = Integer.MIN_VALUE;
            for(int i=0;i<n;i+=k){
                int mine = Integer.MAX_VALUE;
                int maxe = Integer.MIN_VALUE;
                int bp = 0;

                for(int j=i;j<i+k;j++){
                    maxe = Math.max(maxe,nums[j]);
                    mine = Math.min(mine,nums[j]);
                    int next = (j+1 == i+k) ? i : j+1;
                    if(nums[j] > nums[next]) bp++;
                }

                if(bp >= 2){
                    flag = true;
                    break;
                }
                if(prev > mine){
                    flag = true;
                    break;
                }
                prev = maxe;
            }
            if(!flag) ans += k;
        }
        return ans;
    }
}