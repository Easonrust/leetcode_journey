class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] window = new int[26];
        int[] needs = new int[26];
        for(char ch1:s1.toCharArray()){
            needs[ch1-'a']++;
        }
        int left = 0;
        int right = 0;
        while(right<s2.length()){
            char in = s2.charAt(right);
            right++;
            window[in-'a']++;
            while(right-left>s1.length()){
                char out = s2.charAt(left);
                left++;
                window[out-'a']--;
            }
            if(right-left==s1.length()){
                boolean flag = true;
                for(int i=0; i<26; ++i){
                    if(window[i]!=needs[i]){
                        flag = false;
                        break;
                    }
                }
                if(flag==true){
                    return true;
                }
            }
        }
        return false;
    }
}