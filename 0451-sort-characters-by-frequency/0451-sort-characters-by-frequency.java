class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> mp = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(mp.containsKey(ch)){
                mp.put(ch,mp.get(ch)+1);
            }else{
                mp.put(ch,1);
            }
        }

        List<Map.Entry<Character,Integer>> list = new ArrayList<>(mp.entrySet());
        Collections.sort(list,(a,b)->b.getValue().compareTo(a.getValue()));

        StringBuilder str = new StringBuilder();
        for(Map.Entry<Character,Integer> e : list){
            char ch = e.getKey();
            int val = e.getValue();
            for(int i=0;i<val;i++){
                str.append(ch);
            }
        }
        return str.toString();
    }
}