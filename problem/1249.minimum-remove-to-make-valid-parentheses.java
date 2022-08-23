class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> idxToRemove = new HashSet<>();
        Deque<Integer> stack = new LinkedList<>();
        for(int i=0; i<s.length(); ++i){
            char ch = s.charAt(i);
            if(ch=='('){
                stack.push(i);
            }else if(ch==')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    idxToRemove.add(i);
                }
            }
        }
        
        while(!stack.isEmpty()){
            idxToRemove.add(stack.pop());
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); ++i){
            if(idxToRemove.contains(i)){
                continue;
            }
            sb.append(s.charAt(i));
        }
        
        return sb.toString();
    }
}