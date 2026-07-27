class Solution {

    int lowerbound(List<Integer> l, int target){
        int low = 0;
        int high = l.size() - 1;
        int ans = l.size();
        while(low <= high){
            int mid = low + (high-low)/2;
            if(l.get(mid) == target) return mid;
            else if(l.get(mid) < target){
                low = mid + 1;
            }else{
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }

    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> l = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(l.size() == 0 || l.get(l.size()-1) < nums[i]){
                l.add(nums[i]);
            }else{
                int idx = lowerbound(l,nums[i]);
                l.set(idx,nums[i]);
            }
        }
        return l.size();
    }
}