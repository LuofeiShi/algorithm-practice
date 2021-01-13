public Solution {
	public int twoSum(int[] nums, int target) {
		if (nums == null || nums.length < 2) {
			return 0;
		}

		Arrays.sort(nums);

		int left = 0, right = nums.length - 1;
		int count = 0;
		while (left < right) {
			if (nums[left] + nums[right] <= target) {
				left++;
			} else {
				count += right - left;
				right--;
			}
		}

		return count;
	}
}