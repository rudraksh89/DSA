
class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        
        int n = nums.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;       
        }
        Arrays.sort(arr,(a, b)-> Integer.compare(a[0], b[0]));
        int st = 0;
        while (st < n) {
            int end = st;
            while (end+1 < n && arr[end+1][0] - arr[end][0] <= limit) {
                end++;
            }
            ArrayList<Integer> idx = new ArrayList<>();
            ArrayList<Integer> val = new ArrayList<>();
            for (int i = st; i <= end; i++) {
                idx.add(arr[i][1]);
                val.add(arr[i][0]);
            }
            Collections.sort(idx);
            for (int i = 0; i < idx.size(); i++) {
                nums[idx.get(i)] = val.get(i);
            }
            st = end + 1;
        }
        return nums;
    }
}