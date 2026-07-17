class Solution {

    public static void fn(int idx, int[] arr, int target, List<List<Integer>> l, List<Integer> newList){
        int n = arr.length;
            if(target == 0){
                l.add(new ArrayList<>(newList));
                return;
            }
            

        for(int i=idx;i<n;i++){
            if(i>idx && arr[i] == arr[i-1]) continue;
            if(arr[i] > target) break;
            newList.add(arr[i]);
            fn(i+1,arr,target-arr[i],l,newList);
            newList.remove(newList.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> l = new ArrayList<>();
        Arrays.sort(candidates);
        fn(0,candidates,target,l,new ArrayList<>());
        return l;
    }
}
