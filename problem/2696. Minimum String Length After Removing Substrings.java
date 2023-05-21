class Solution {
    public int minLength(String s) {
        Deque<Character> stack = new LinkedList<>();
        for(int i=0; i<s.length(); ++i){
            char ch = s.charAt(i);
            if(!stack.isEmpty()&&((stack.getLast()=='A'&&ch=='B')||(stack.getLast()=='C'&&ch=='D'))){
                stack.removeLast();
                continue;
            }
            stack.addLast(ch);
        }
        return stack.size();
    }
}