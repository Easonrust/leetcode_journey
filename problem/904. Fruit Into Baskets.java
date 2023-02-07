class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0;
        int right = 0;
        int cnt = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while(right<fruits.length) {
            int in = fruits[right];
            right++;
            map.put(in, map.getOrDefault(in, 0)+1);
            cnt++;
            while(map.keySet().size()>2) {
                int out = fruits[left];
                left++;
                map.put(out, map.get(out)-1);
                if(map.get(out)==0){
                    map.remove(out);
                }
                cnt--;
            }
            res = Math.max(res, cnt);
        }
        return res;
    }
}