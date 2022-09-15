class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if(n%2!=0){
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        Arrays.sort(changed);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; ++i){
            int num = changed[i];
            if(num%2==0){
                if(map.containsKey(num/2)&&map.get(num/2)>0){
                    list.add(num/2);
                    map.put(num/2, map.get(num/2)-1);
                    continue;
                }
            }
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        if(list.size()!=n/2){
            return new int[0];
        }
        int[] res = new int[n/2];
        for(int i=0; i<n/2; ++i){
            res[i] = list.get(i);
        }
        return res;
    }
}