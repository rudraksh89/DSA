class Solution {
    public List<List<String>> findMismatchedSegments(String s1, String s2) {
        List<List<String>> l = new ArrayList<>();
        int n = s1.length();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for(int i=0;i<n;i++){
            if(s1.charAt(i) != s2.charAt(i)){
                sb1.append(s1.charAt(i));
                sb2.append(s2.charAt(i));
            }else{
                if (sb1.length() > 0) {
                    List<String> newl = new ArrayList<>();
                    newl.add(sb1.toString());
                    newl.add(sb2.toString());
                    l.add(newl);

                    sb1.setLength(0);
                    sb2.setLength(0);
                }
            }
        }
        if (sb1.length() > 0) {
            List<String> newl = new ArrayList<>();
            newl.add(sb1.toString());
            newl.add(sb2.toString());
            l.add(newl);
        }
        return l;
    }
}