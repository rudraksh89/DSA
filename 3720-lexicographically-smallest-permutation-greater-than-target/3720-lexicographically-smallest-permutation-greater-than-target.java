class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        String ans = "";
        int[] fre = new int[26];
        for(int i=0;i<s.length();i++){
            fre[s.charAt(i) - 'a']++;
        }

        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = target.charAt(i);
            if(fre[ch - 'a'] > 0){
                sb.append(ch);
                fre[ch - 'a']--;
            }else{
                for(int j=ch-'a'+1;j<26;j++){
                    if(fre[j] > 0){
                        sb.append((char)('a'+j));
                        fre[j]--;

                        for(int k=0;k<26;k++){
                            while(fre[k] > 0){
                                sb.append((char)('a'+k));
                                fre[k]--;
                            }
                        }
                        return sb.toString();
                    }
                }
                break;
            }
        }

        for(int i=sb.length()-1;i>=0;i--){
            char del = sb.charAt(sb.length()-1);
            sb.deleteCharAt(sb.length()-1);
            fre[del-'a']++;
            char ch = target.charAt(i);
            for(int j=ch-'a'+1;j<26;j++){
                if(fre[j] > 0){
                    sb.append((char)('a'+j));
                    fre[j]--;

                    for(int k=0;k<26;k++){
                        while(fre[k] > 0){
                            sb.append((char)('a'+k));
                            fre[k]--;
                        }
                    }
                    return sb.toString();
                }
            }
        }
        return "";
    }
}