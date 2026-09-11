class Solution {
    public int totalNumbers(int[] digits) {
        HashSet<Integer> set = new HashSet<>();
        int n = digits.length;
        for(int i=0;i<n;i++){
            if(digits[i] == 0) continue;
            for(int j=0;j<n;j++){
                if(i == j) continue;
                for(int k=0;k<n;k++){
                    if(k == i || k == j) continue;
                    int c = (digits[i]*100) + (digits[j]*10) + digits[k];
                    if(c % 2 == 0) set.add(c);
                }
            }
        }
        return set.size();
    }
}


// class Solution {

//     HashSet<Integer> set = new HashSet<>();
//     void fn(int idx, int num, int pro, int[]digits, int[]vis){
//         if(idx == 3){
//             if(num % 2 == 0) set.add(num);
//             return;
//         }
//         for(int i=0;i<digits.length;i++){
//             if(vis[i] == 1) continue;
//             if(idx == 0 && digits[i] == 0) continue;
//             vis[i] = 1;
//             fn(idx+1,num+(digits[i]*pro),pro/10,digits,vis);
//             vis[i] = 0;
//         }

//     }
//     public int totalNumbers(int[] digits) {
//         int res = 0;
//         int n = digits.length;
//         int[] vis = new int[n];
//         fn(0,0,100,digits,vis);
//         return set.size();
//     }
// }