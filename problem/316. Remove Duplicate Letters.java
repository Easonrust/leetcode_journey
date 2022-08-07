class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIdx = new int[26];
        for(int i=0; i<s.length(); ++i){
            char ch = s.charAt(i);
            lastIdx[ch-'a'] = i;
        }
        
        Deque<Character> stack = new LinkedList<>();
        boolean[] visited = new boolean[26];
        
        for(int i=0; i<s.length(); ++i){
            char ch = s.charAt(i);
            if(visited[ch-'a']){
                continue;
            }
            while(!stack.isEmpty()&&stack.getLast()>ch&&lastIdx[stack.getLast()-'a']>i){
                visited[stack.removeLast()-'a'] = false;
            }
            stack.addLast(ch);
            visited[ch-'a'] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.removeFirst());
        }
        
        return sb.toString();
    }
}
