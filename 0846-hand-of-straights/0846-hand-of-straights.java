class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0) return false;
        Arrays.sort(hand);
        TreeMap<Integer,Integer> mp = new TreeMap<>();
        for(int i=0;i<n;i++){
            mp.put(hand[i],mp.getOrDefault(hand[i],0)+1);
        }
        while(!mp.isEmpty()){
            int a = mp.firstKey();
            for(int i=0;i<groupSize;i++){
                int j = a + i;
                if(!mp.containsKey(j)) return false;
                mp.put(j,mp.get(j)-1);
                if(mp.get(j) == 0) mp.remove(j);
            }
        }
        return true;
    }
}
//1 2 2 3 3 4 6 7 8 