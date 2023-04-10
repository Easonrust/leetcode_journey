class Solution {
    public String removeDuplicates(String s, int k) {
        Deque<Integer> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder(s);
        for(int i=0; i<sb.length(); ++i){
            if(i==0||sb.charAt(i)!=sb.charAt(i-1)){
                stack.push(1);
            }else{
                int top = stack.pop();
                top += 1;
                if(top==k){
                    sb.delete(i-k+1, i+1);
                    i = i - k;
                }else{
                    stack.push(top);
                }
            }
        }
        return sb.toString();
    }
}