class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] window = new int[26];
        int[] needs = new int[26];
        for(char ch:p.toCharArray()){
            needs[ch-'a']++;
        }
        int left = 0;
        int right = 0;
        List<Integer> res = new ArrayList<>();
        while(right<s.length()){
            char in = s.charAt(right);
            window[in-'a']++;
            right++;
            while(right-left>p.length()){
                char out = s.charAt(left);
                window[out-'a']--;
                left++;
            }
            if(right-left==p.length()){
                boolean match = true;
                for(int i=0; i<26; ++i){
                    if(window[i]!=needs[i]){
                        match = false;
                        break;
                    }
                }
                if(match){
                    res.add(left);
                }
            }
        }
        return res;
    }
}