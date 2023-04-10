class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(slots1, (o1,o2)->(o1[0]-o2[0]));
        Arrays.sort(slots2, (o1,o2)->(o1[0]-o2[0]));
        int i = 0;
        int j = 0;
        int m = slots1.length;
        int n = slots2.length;
        while(i<m&&j<n){
            int[] slot1 = slots1[i];
            int[] slot2 = slots2[j];
            int left = Math.max(slot1[0], slot2[0]);
            int right = Math.min(slot1[1], slot2[1]);
            if(right-left>=duration){
                res.add(left);
                res.add(left+duration);
                return res;
            }
            if(slot1[1]<slot2[1]){
                i++;
            }else{
                j++;
            }
        }
        return res;
    }
}