class Solution {
    
    int fn(int num){
        int sum = 0;
        while(num > 0){
            int rem = num % 10;
            sum += rem;
            num /= 10;
        }
        return sum;
    }
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[] arr = nums.clone();
        Integer[] target = new Integer[n];
        for(int i=0;i<n;i++){
            target[i] = nums[i];
        }

        Arrays.sort(target ,(a,b)->{
            int s1 = fn(a);
            int s2 = fn(b);
            if(s1 != s2) return Integer.compare(s1,s2);
            return Integer.compare(a,b);
        });

        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(arr[i],i);
        }
        int count = 0;
        for(int i=0;i<n;i++){
            if(arr[i] == target[i]) continue;
            int a = mp.get(target[i]);
            int temp = arr[i];
            arr[i] = arr[a];
            arr[a] = temp;
            count++;

            mp.put(arr[i],i);
            mp.put(arr[a],a);
        }
        
        return count;
    }
}

// 18 43 34 16
// 16 34 43 18