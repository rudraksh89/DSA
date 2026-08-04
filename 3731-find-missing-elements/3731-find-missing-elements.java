class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> l = new ArrayList<>();
        Arrays.sort(nums);
        int st = nums[0];
        int end = nums[nums.length-1];
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        for(int i = st ; i <= end ; i++){
            if(!mp.containsKey(i)) l.add(i);
        }
        return l;
    }
}