class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] window = new int[26];
        int[] needs = new int[26];

        for (char c : p.toCharArray()) {
            needs[c - 'a']++;
        }

        int left = 0;
        int right = 0;
        List<Integer> res = new ArrayList<>();
        while (right < s.length()) {
            char c1 = s.charAt(right);
            right++;

            window[c1 - 'a']++;

            while (right - left > p.length()) {
                char c2 = s.charAt(left);
                left++;

                window[c2 - 'a']--;
            }

            if (right - left == p.length()) {
                boolean flag = true;
                for (int i = 0; i < window.length; ++i) {
                    if (window[i] != needs[i]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    res.add(left);
                }
            }
        }
        return res;
    }
}