class MyCalendarThree {

    TreeMap<Integer,Integer> mp = new TreeMap<>();
    public MyCalendarThree() {
        
    }
    
    public int book(int startTime, int endTime) {
        mp.put(startTime,mp.getOrDefault(startTime,0)+1);
        mp.put(endTime,mp.getOrDefault(endTime,0)-1);
        int max = 0;
        int curr = 0;

        for(Map.Entry<Integer,Integer> e : mp.entrySet()){
            int key = e.getKey();
            int val = e.getValue();
            curr += val;
            if(curr > max){
                max = curr;
            }
        }
        return max;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */