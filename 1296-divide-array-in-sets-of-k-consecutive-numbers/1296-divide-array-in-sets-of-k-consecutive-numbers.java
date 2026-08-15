class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        if(n % k != 0) return false;
        Arrays.sort(nums);
        TreeMap<Integer,Integer> mp = new TreeMap<>();
        for(int i=0;i<n;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }

        while(!mp.isEmpty()){
            int curr = mp.firstKey();
            for(int i=0;i<k;i++){
                int next = curr + i;
                if(!mp.containsKey(next)) return false;
                mp.put(next,mp.get(next)-1);
                if(mp.get(next) == 0) mp.remove(next);
            }
        }
        return true;
    }
}

// 1 - 3
// 2 - 6
// 3 - 3 
// 4 - 3