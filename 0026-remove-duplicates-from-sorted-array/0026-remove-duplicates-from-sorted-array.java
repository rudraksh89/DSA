class Solution {
    public int removeDuplicates(int[] nums) {
        List<Integer> l = new ArrayList<>();
        l.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1]) continue;
            else l.add(nums[i]);
        }
        int n = l.size();
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = l.get(i);
        }
        return ans.length;
    }
}