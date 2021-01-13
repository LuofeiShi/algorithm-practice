class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        // using hash
        Map<Integer, Integer> map = new HashMap<>();
        // iterate the nums
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        
        for (int i = 0; i < nums.length; i++) {
            int j = target - nums[i];
            if (map.containsKey(j) && i != map.get(j)) {
                result[0] = i;
                result[1] = map.get(j);
                break;
            }
        }
        return result;
    }
}
