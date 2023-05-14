class Solution {
    public int[] circularGameLosers(int n, int k) {
        Set<Integer> set = new HashSet<>();
        int friend = 1;
        int turn = 1;
        set.add(friend);
        while(true){
            friend = (friend+turn*k)%n;
            if(friend==0){
                friend = n;
            }
            if(set.contains(friend)){
                break;
            }else{
                set.add(friend);
                turn++;
            }
        }
        int[] res = new int[n-set.size()];
        int j=0;
        for(int i=1; i<=n; ++i){
            if(set.contains(i)){
                continue;
            }
            res[j] = i;
            j++;
        }
        return res;
    }
}