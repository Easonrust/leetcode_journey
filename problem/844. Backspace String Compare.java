class Solution {
    public boolean backspaceCompare(String s, String t) {
        Deque<Character> dq1 = new LinkedList<>();
        Deque<Character> dq2 = new LinkedList<>();
        for(int i=0; i<s.length(); ++i){
            char ch = s.charAt(i);
            if(ch!='#'){
                dq1.addLast(ch);
            }else{
                if(dq1.isEmpty()){
                    continue;
                }else{
                    dq1.removeLast();
                }
            }
        }
        for(int i=0; i<t.length(); ++i){
            char ch = t.charAt(i);
            if(ch!='#'){
                dq2.addLast(ch);
            }else{
                if(dq2.isEmpty()){
                    continue;
                }else{
                    dq2.removeLast();
                }
            }
        }
        if(dq1.size()!=dq2.size()){
            return false;
        }
        while(!dq1.isEmpty()){
            if(dq1.pop()!=dq2.pop()){
                return false;
            }
        }

        return true;
    }
}