// http://www.lintcode.com/en/problem/two-sum-unique-pairs/
public Solution {
	public int twoSum(int[] nums, int target) {
		if (nums == null || nums.length < 2) {
			return 0;
		}

		Arrays.sort(nums);
		int cnt = 0;
		int left = 0, right = nums.length - 1;

		while (left < right) {
			int sum = nums[left] + nums[right];
			if (sum == target) {
				cnt++;
				left++;
				right--;
				while (left < right && nums[right] == nums[right + 1]) {
					right--;
				}
				while (left < right && nums[left] == nums[left - 1]) {
					left++;
				}
			} else if (sum < target) {
				left++;
			} else {
				right--;
			}
		}

		return cnt;
	}
}