class Solution {
    public int minRange(int a, int b, int c) {
        int originalrange = Math.max(a,Math.max(b,c)) - Math.min(a,Math.min(b,c));
        int sum = a + b + c;
        int large = Math.max(a,Math.max(b,c));
        int small = Math.min(a,Math.min(b,c));
        int mid = sum - (large + small);
        large = small + mid;
        int updatedrange = large - small;
        return Math.min(originalrange,updatedrange);
    }
}
// 7 2 5 
// 9 14 5
// 9,2,11