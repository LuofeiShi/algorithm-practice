class Solution {
	/**
	 * @param nums: A set of numbers.
	 * @return: A list of lists. All valid subsets
	 */
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> results = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return results;
		}

		Arrays.sort(nums);

		List<Integer> subset = new ArrayList<>();
		subsetsHelper(nums, 0, subset, results);

		return results;
	}

	private void subsetsHelper(int[] nums, int startIndex,
		List<Integer> subset, List<List<Intger>> results) {
		// deep copy subset & add to results
		results.add(new ArrayList<Integer>(subset));

		for (int i = startIndex; i < nums.length; i++) {
			subset.add(nums[i]);
			subsetsHelper(nums, i + 1, subset, results);
			subset.remove(subset.size() - 1);
		}
	}
}