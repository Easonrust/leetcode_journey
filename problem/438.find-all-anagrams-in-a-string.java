class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] window = new int[26];
        int[] needs = new int[26];
        for(char c:p.toCharArray()){
            needs[c-'a']++;
        }
        int left = 0;
        int right = 0;
        int n = s.length();
        List<Integer> res = new ArrayList<>();
        while(right<n){
            char in = s.charAt(right);
            right++;
            window[in-'a']++;

            while(right-left>p.length()){
                char out = s.charAt(left);
                left++;
                window[out-'a']--;
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