// 暴力解法
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2]; 
        for (int i = 0; i < nums.length; i++) {
            int n = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == n) {
                    res = new int[]{i, j}; 
                }
            } 
        }
        return res;
    }
}

// HashMap
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2]; 
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i< nums.length; i++) {
            int num = target - nums[i];
            // 如果 HashMap 中有另一个组成数，则返回结果；否则将此数存入哈希表中
            if (map.containsKey(num)) {
                return new int[]{map.get(num), i};
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
