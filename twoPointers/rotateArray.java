class Solution {
	public void rotate(int[] nums, int k) {
		if (nums == null || k == 0) {
			return;
		}

		k = k % nums.length;

		// three-step reverse
		reverse(nums, 0, nums.length - k - 1);
		reverse(nums, nums.length - k, nums.length - 1);
		reverse(nums, 0, nums.length - 1);
	}

	private void reverse(int[] nums, int start, int end) {
		for (int i = start, j = end; i < j; i++, j--) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
	}
}