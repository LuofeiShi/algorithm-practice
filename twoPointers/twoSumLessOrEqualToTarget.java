public Solution {
	public int twoSum(int[] nums, int target) {
		if (nums == null || nums.length < 2) {
			return 0;
		}

		Arrays.sort(nums);
		int count = 0;
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			if (nums[left] + nums[right] > target) {
				right--;
			} else {
				count += right - left;
				left++;
			}
		}
		return count;
	}
}