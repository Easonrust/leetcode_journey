class Solution {
    public int maxVowels(String s, int k) {
        int res = 0;
        int l = 0;
        int r = 0;
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        int cnt = 0;
        while(r<s.length()){
            char in = s.charAt(r);
            r++;

            if(vowels.contains(in)){
                cnt++;
            }

            while(r-l>k){
                char out = s.charAt(l);
                l++;
                if(vowels.contains(out)){
                    cnt--;
                }
            }

            if(r-l==k){
                res = Math.max(res, cnt);
            }
        }

        return res;
    }
}