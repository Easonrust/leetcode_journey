class Solution {
    public boolean canReorderDoubled(int[] arr) {
        int n = arr.length;
        int m = n/2;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        for(int i=0; i<n; ++i){
            int num = arr[i];
            if(num%2==0&&num>0){
                if(map.containsKey(num/2)&&map.get(num/2)>0){
                    map.put(num/2, map.get(num/2)-1);
                    list.add(num/2);
                    continue;
                }
            }else{
                if(map.containsKey(num*2)&&map.get(num*2)>0){
                    map.put(num*2, map.get(num*2)-1);
                    list.add(num*2);
                    continue;
                }
            }
            map.put(num, map.getOrDefault(num,0)+1);
        }
        if(list.size()==m){
            return true;
        }
        return false;
    }
}