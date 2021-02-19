class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int k = j + 1, u = nums.length - 1; k < u; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }
                    while (u - 1 > k && nums[i] + nums[j] + nums[k] + nums[u - 1] >= target) {
                        u--;
                    }
                    if (nums[i] + nums[j] + nums[k] + nums[u] == target) {
                        List<Integer> currentResult = new ArrayList<>();
                        Collections.addAll(currentResult, nums[i], nums[j], nums[k], nums[u]);
                        results.add(currentResult);
                    }
                }
            }
        }
        return results;
    }
}
