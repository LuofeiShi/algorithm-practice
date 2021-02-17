class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = Integer.MAX_VALUE;
        result[1] = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1, k = nums.length - 1; j < k; j++) {
                // find the lowest
                while (k - 1 > j && nums[i] + nums[j] + nums[k - 1] >= target) {
                    k--;
                }
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum - target) < result[0]) {
                    result[0] = Math.abs(sum - target);
                    result[1] = sum;
                }
                if (k - 1 > j) {
                    sum = nums[i] + nums[j] + nums[k - 1];
                    if (Math.abs(sum - target) < result[0]) {
                        result[0] = Math.abs(sum - target);
                        result[1] = sum;
                    }
                }
            }
        }
        return result[1];
    }
}
