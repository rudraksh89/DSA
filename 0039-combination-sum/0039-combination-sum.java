class Solution {

    public static void fn(int idx, int[] candidates, int target, List<List<Integer>> l, List<Integer> newList){
        int n = candidates.length;
        if(idx == n){
            if(target == 0){
                l.add(new ArrayList<>(newList));
            }
            return;
        }
        if(candidates[idx] <= target){
            newList.add(candidates[idx]);
            fn(idx,candidates,target-candidates[idx],l,newList);
            newList.remove(newList.size()-1);
        }
        fn(idx+1,candidates,target,l,newList);
        return;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> l = new ArrayList<>();
        fn(0,candidates,target,l,new ArrayList<>());
        return l;
    }
}