class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> dq = new LinkedList<>();
        
        for(int i = 0; i<num.length(); ++i){
            char ch = num.charAt(i);
            while(!dq.isEmpty()&&dq.getLast()>ch&&k!=0){
                dq.removeLast();
                k--;
            }
            
            dq.addLast(ch);
        }
        
        for(int i=0; i<k; ++i){
            dq.removeLast();
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!dq.isEmpty()){
            char ch = dq.removeFirst();
            if(ch=='0'&&sb.length()==0){
                continue;
            }
            sb.append(ch);
        }
        
        if(sb.length()==0){
            return "0";
        }
        
        return sb.toString();
    }
}