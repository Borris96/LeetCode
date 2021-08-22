class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }

        Arrays.sort(nums);
        // [-4, -1, -1, 0, 1, 2]

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 转化为两数之和为 -nums[i]
            int target = -nums[i]; 

            // 双指针
            int left = i+1;
            int right = nums.length-1;

            while(left < right){
                if(nums[left] + nums[right] < target){
                    left++;
                }
                else if(nums[left] + nums[right] > target){
                    right--;
                }
                else{
                    List<Integer> r = new ArrayList<>();
                    r.add(nums[i]);
                    r.add(nums[left]);
                    r.add(nums[right]);
                    res.add(r);
                    //还不能跳出循环，因为可能后面还有不同的组合
                    //为了避免重复还是需要判断左指针后一位是否和左指针重复
                    //右指针前一位是否和右指针重复
                    while(left<right && nums[right]==nums[right-1]){
                        right--;
                    }
                    while(left<right && nums[left] == nums[left+1]){
                        left++;
                    }
                    //去寻找后续的不同组合
                    right--;
                    left++;
                }
            }            
        }

        return res;
    }
}
