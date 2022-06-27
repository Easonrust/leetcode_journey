class Solution {
    String[] mapping = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> res;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if(digits.length()==0){
            return res;
        }
        StringBuilder sb = new StringBuilder();
        backTracking(digits, 0, sb);
        return res;
    }
    
    private void backTracking(String digits, int i, StringBuilder sb){
        if(sb.length()==digits.length()){
            res.add(sb.toString());
            return;
        }
        
        int curNum = digits.charAt(i) - '0';
        for(char c:mapping[curNum].toCharArray()){
            sb.append(c);
            backTracking(digits, i+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}