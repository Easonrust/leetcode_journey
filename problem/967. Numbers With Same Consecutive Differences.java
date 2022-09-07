class Solution {
    List<Integer>  list = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public int[] numsSameConsecDiff(int n, int k) {
        for(int i=1; i<=9; ++i){
            sb.append(i);
            backTracking(n, k, i);
            sb.deleteCharAt(sb.length()-1);
        }
        
        int[] res = new int[list.size()];
        for(int i=0; i<res.length; ++i){
            res[i] = list.get(i);
        }
        return res;
    }
    
    private void backTracking(int n, int k, int pre) {
        if(sb.length()==n){
            list.add(Integer.parseInt(sb.toString()));
            return;
        }
        
        if(pre-k>=0){
            sb.append(pre-k);
            backTracking(n, k, pre-k);
            sb.deleteCharAt(sb.length()-1);
        }
        
        if(pre+k<=9&&pre+k!=pre-k){
            sb.append(pre+k);
            backTracking(n, k, pre+k);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}