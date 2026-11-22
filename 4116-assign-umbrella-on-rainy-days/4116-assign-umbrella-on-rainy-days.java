class Solution {
    public String[] assignUmbrella(int[] rain) {
        int n = rain.length;
        String[] str = new String[n];
        int alice = 0;
        int bob = 0;

        for(int i=0;i<rain.length;i++){
            if(rain[i] == 0){
                str[i] = "None";
            }else{
                if(i+1 <n && rain[i+1] == 1){
                    if(alice > bob){
                        str[i] = "Bob";
                        bob++;
                    }else if(alice < bob){
                        str[i] = "Alice";
                        alice++;
                    }else{
                        str[i] = "Alice";
                        alice++;
                    }
                }else{
                    str[i] = "Bob";
                    bob++;
                }
            }
        }
        return str;
    }
}