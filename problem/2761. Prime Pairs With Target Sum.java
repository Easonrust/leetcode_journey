class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        for(int i=2; i*i<n; ++i){
            if(isPrime[i]){
                for(int j=2*i; j<n; j+=i){
                    isPrime[j] = false;
                }
            }
        }
        for(int i=2; i*2<=n; ++i){
            if(isPrime[i]&&isPrime[n-i]){
                List<Integer> pair = new ArrayList<>();
                pair.add(i);
                pair.add(n-i);
                res.add(pair);
            }
        }
        return res;
    }
    

}