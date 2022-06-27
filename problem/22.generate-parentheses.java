class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backTracking(n, n, sb);
        return res;
    }
    
    private void backTracking(int left, int right, StringBuilder sb){
        if(right<left){
            return;
        }
        
        if(right<0||left<0){
            return;
        }
        
        if(right==0&&left==0){
            res.add(sb.toString());
            return;
        }
        
        sb.append('(');
        backTracking(left-1, right, sb);
        sb.deleteCharAt(sb.length()-1);
        
        sb.append(')');
        backTracking(left, right-1, sb);
        sb.deleteCharAt(sb.length()-1);
    }
}