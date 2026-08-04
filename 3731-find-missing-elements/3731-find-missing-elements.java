class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(nums[i],1);
        }
        List<Integer> l = new ArrayList<>();
        for(int i=nums[0];i<=nums[n-1];i++){
            if(!mp.containsKey(i)){
                l.add(i);
            }
        }
        return l;
    }
}