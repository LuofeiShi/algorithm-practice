public Solution {
	private void reverse(List<Integer> nums, int start, int end) {
		for (int i = start, j = end; i < j; i++, j--) {
			int temp = nums.get(i);
			nums.set(i, nums.get(j));
			nums.set(j, temp);
		}
	}

	public void recoverRotatedSortedArray(List<Integer> nums) {
		for (int index = 0; index < nums.size(); index++) {
			if (nums.get(index) > nums.get(index + 1)) {
				reverse(nums, 0, index);
				reverse(nums, index + 1, nums.size() - 1);
				reverse(nums, 0, nums.size() - 1);
				return;
			}
		}
	}
}