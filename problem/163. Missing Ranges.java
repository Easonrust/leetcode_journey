class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if(nums.length==0){
            addToList(lower, upper, res);
            return res;
        }
        if(lower<nums[0]){
            addToList(lower, nums[0]-1, res);
        }
        int left = nums[0] + 1;
        for(int i=1; i<nums.length; ++i){
            if(nums[i]>left){
                addToList(left, nums[i]-1, res);
            }
            left = nums[i]+1;
        }
        if(upper>=left){
            addToList(left, upper, res);
        }
        return res;
    }

    private void addToList(int left, int right, List<String> res){
        if(left==right){
            res.add(String.valueOf(left));
            return;
        }
        res.add(String.valueOf(left)+"->"+String.valueOf(right));
    }
}