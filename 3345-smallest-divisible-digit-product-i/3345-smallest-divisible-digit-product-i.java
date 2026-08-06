class Solution {

    boolean fn(int n, int t){
        int pro = 1;
        while(n > 0){
            int last = n % 10;
            pro *= last;
            n /= 10;
        }
        return pro % t == 0;
    }
    public int smallestNumber(int n, int t) {
        for(int i=n;i<=100;i++){
            if(fn(i,t)) return i;
        }
        return 0;
    }
}