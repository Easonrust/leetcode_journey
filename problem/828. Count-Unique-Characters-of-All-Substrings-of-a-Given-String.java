class Solution {
    public int uniqueLetterString(String s) {
        int[][] index = new int[26][2];
        for (int i = 0; i < 26; ++i) Arrays.fill(index[i], -1);
        int res = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int c = s.charAt(i) - 'A';
            res += (i - index[c][1]) * (index[c][1] - index[c][0]);
            index[c] = new int[] {index[c][1], i};
        }
        for (int c = 0; c < 26; ++c)
            res +=(n - index[c][1]) * (index[c][1] - index[c][0]);
        return res;
    }
}

// index[i][0] 和 index[i][1] 存储最后两次出现该字母的位置
// 最后只处理到了倒数第二个，对于倒数第一个要再加一层循环