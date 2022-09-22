class Solution {
    public String reverseWords(String s) {
        String[] strs = s.split("\\s+");
        StringBuilder res = new StringBuilder();
        res.append(new StringBuilder(strs[0]).reverse().toString());
        for(int i=1; i<strs.length; ++i){
            res.append(" ");
            res.append(new StringBuilder(strs[i]).reverse().toString());
        }
        return res.toString();
    }
}
