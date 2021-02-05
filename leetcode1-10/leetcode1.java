class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return null;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int r = target - nums[i];
            if (map.containsKey(r)) {
                return new int[]{map.get(r), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
