class Solution {
    boolean[] used;
    StringBuilder sb = new StringBuilder();
    boolean res = false;
    public boolean reorderedPowerOf2(int n) {
        String str = String.valueOf(n);
        used = new boolean[str.length()];
        backTracking(str);
        return res;
    }
    
    private void backTracking(String str) {
        if(res == true){
            return;
        }
        
        if(sb.length()>=1&&sb.charAt(0)=='0'){
            return;
        }
        
        if(sb.length()==str.length()){
            int num = Integer.parseInt(sb.toString());
            if(check(num)){
                res = true;
            }
        }
        
        for(int i=0; i<str.length(); ++i){
            if(used[i]){
                continue;
            }
            sb.append(str.charAt(i));
            used[i] = true;
            backTracking(str);
            used[i] = false;
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
    private boolean check(int num) {
        return (num & num-1) == 0;
    }
}
