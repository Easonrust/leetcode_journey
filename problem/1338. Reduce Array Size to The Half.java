class Solution {
    public int minSetSize(int[] arr) {
        int n = arr.length/2;
        Map<Integer, Integer> map = new HashMap<>();
        for(int a:arr){
            map.put(a, map.getOrDefault(a, 0)+1);
        }
        
        List<Integer> list = new ArrayList<>();
        for(int key:map.keySet()){
            list.add(key);
        }
        
        Collections.sort(list, (o1,o2)->(map.get(o2)-map.get(o1)));
        
        int res = 0;
        int sum = 0;
        for(int i=0; i<list.size()&&sum<n; ++i){
            int num = list.get(i);
            res ++;
            sum += map.get(num);
        }
        
        return res;
    }
}
