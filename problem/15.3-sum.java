class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<n-2; ++i){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int first = nums[i];
            int lo = i+1;
            int hi = n-1;
            while(lo<hi){
                int second = nums[lo];
                int third = nums[hi];
                int sum = first+second+third;
                if(sum==0){
                    res.add(Arrays.asList(first, second, third));
                    while(lo<hi&&nums[lo]==second){
                        lo++;
                    }
                    while(lo<hi&&nums[hi]==third){
                        hi--;
                    }
                }else if(sum<0){
                    while(lo<hi&&nums[lo]==second){
                        lo++;
                    }
                }else{
                    while(lo<hi&&nums[hi]==third){
                        hi--;
                    }
                }
            }
        }
        return res;
    }

    
}