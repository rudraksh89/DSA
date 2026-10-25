class Solution {
    public int countStaircase(int[] nums) {
        int n = nums.length;
        int count = 0;

        for(int i=0;i<n;i++){
            HashMap<Integer,Integer> mp = new HashMap<>();
            for(int j=i;j<n;j++){
                mp.put(nums[j],mp.getOrDefault(nums[j],0)+1);
                int dist = mp.size();
                int size = j-i+1;
                int se = dist * (dist+1)/2;
                if(size != se) continue;

                boolean flag = false;
                int ex = 1;
                HashSet<Integer> set = new HashSet<>();
                for(int k=i;k<=j;k++){
                    if(!set.contains
                    (nums[k])){
                        set.add(nums[k]);
                        if(mp.get(nums[k]) != ex){
                            flag = true;
                            break;
                        }
                        ex++;
                    }
                }
                if(!flag) count++;
            }
        }

        return count;
    }
}