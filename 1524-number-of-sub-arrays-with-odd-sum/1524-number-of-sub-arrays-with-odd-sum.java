class Solution {
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int even = 1;
        int odd = 0;
        int sum = 0;
        int count = 0;
        int mod = 1000000007;
        for(int i=0;i<n;i++){
            sum += arr[i];
            if(sum % 2 == 0){
                count = (count + odd) % mod;
                even++;
            }else{
                count = (count + even) % mod;
                odd++;
            }
        }
        return count;
    }
}
// e + o = o
// e + e = e
// o + o = e 

// 1 4 9 

// 1 2 3 4 5 6 7
// 1 3 6 10 15 21 28

// till 1  : 1
// till 2 : 1 , 2, 3
// till 3 : 1 ,2, 3, 3, 6,

// till 1 : 1
// till 3 : 1,3,4
// till 5 : 1,3,4,5,9

