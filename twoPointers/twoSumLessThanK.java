class Solution {
	public int twoSumLessThanK(int[] nums, int k) {
		if (nums == null || nums.length < 2) {
			return -1;
		}

		Arrays.sort(nums);
		int closest = k;
		int left = 0, right = nums.length - 1;

		while (left < right) {
			int sum = nums[left] + nums[right];
			if (sum < k) {
				if (closest == k || sum > closest) {
					closest = sum;
				}
				left++;
			} else {
				right--;
			}
		}

		return closest < k ? closest : -1;
	}
}