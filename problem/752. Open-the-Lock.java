class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        for(String deadend:deadends){
            deads.add(deadend);
        }
        Set<String> visited = new HashSet<>();
        String start = "0000";
        if(deads.contains(start)){
            return -1;
        }
        visited.add(start);
        Deque<String> q = new LinkedList<>();
        q.addLast(start);
        int step = 0;
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i=0;i<sz;++i){
                String cur = q.removeFirst();
                
                if(cur.equals(target)){
                    return step;
                }
                
                for(int j=0;j<4;++j){
                    String minusOne = getMinusOne(cur,j);
                    String addOne = getAddOne(cur,j);
                    if(!deads.contains(minusOne)&&!visited.contains(minusOne)){
                        visited.add(minusOne);
                        q.addLast(minusOne);
                    }
                    if(!deads.contains(addOne)&&!visited.contains(addOne)){
                        visited.add(addOne);
                        q.addLast(addOne);
                    }
                }
            }
            step++;
        }
        return -1;
    }
    
    private String getMinusOne(String cur, int j){
        StringBuilder sb = new StringBuilder(cur);
        if(sb.charAt(j)=='0'){
            sb.setCharAt(j, '9');
            return sb.toString();
        }
        
        sb.setCharAt(j, (char)(sb.charAt(j)-1));
        return sb.toString();
    }
    
    private String getAddOne(String cur, int j){
        StringBuilder sb = new StringBuilder(cur);
        if(sb.charAt(j)=='9'){
            sb.setCharAt(j, '0');
            return sb.toString();
        }
        
        sb.setCharAt(j, (char)(sb.charAt(j)+1));
        return sb.toString();
    }
}