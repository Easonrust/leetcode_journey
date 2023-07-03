class Solution {
    public boolean buddyStrings(String s, String goal) {
        int cnt = 0;
        if(s.length()!=goal.length()){
            return false;
        }
        if(s.equals(goal)){
            int[] cnts = new int[26];
            for(int i=0; i<s.length(); ++i){
                cnts[s.charAt(i)-'a']++;
                if(cnts[s.charAt(i)-'a']==2){
                    return true;
                }
            }
            return false;
        }
        int first = 0;
        int second = 0;
        for(int i=0; i<s.length(); ++i){
            if(s.charAt(i)!=goal.charAt(i)){
                cnt++;
                if(cnt>2){
                    return false;
                }else if(cnt==1){
                    first = s.charAt(i);
                    second = goal.charAt(i);
                }else{
                    if(s.charAt(i)==second&&goal.charAt(i)==first){
                        continue;
                    }else{
                        return false;
                    }
                }
            }
        }
        return cnt==2;
    }
}