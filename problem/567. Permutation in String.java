class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] window = new int[26];
        int[] needs = new int[26];

        for (char c : s1.toCharArray()) {
            needs[c - 'a']++;
        }

        int left = 0;
        int right = 0;
        List<Integer> res = new ArrayList<>();
        while (right < s2.length()) {
            char c1 = s2.charAt(right);
            right++;

            window[c1 - 'a']++;

            while (right - left > s1.length()) {
                char c2 = s2.charAt(left);
                left++;

                window[c2 - 'a']--;
            }

            if (right - left == s1.length()) {
                boolean flag = true;
                for (int i = 0; i < window.length; ++i) {
                    if (window[i] != needs[i]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }
}
