public class Solution {
	public List<List<Integer>> threeSum(int[] numbers) {
		Arrays.sort(numbers);

		List<List<Integer>> results = new ArrayList<>();

		for (int i = 0; i < numbers.length; i++) {
			if (i != 0 && numbers[i] == numbers[i - 1]) {
				continue;
			}
			findTwoSum(numbers, i, results);
		}

		return results;
	}

	private void findTwoSum(int[] nums, int index, List<List<Integer>> results) {
		int left = index + 1, right = nums.length - 1;
		int target = -nums[index];

		while (left < right) {
			int twoSum = nums[left] + nums[right];
			if (twoSum < target) {
				left++;
			} else if (twoSum > target) {
				right--;
			} else {
				List<Integer> triple = new ArrayList<>();
				triple.add(nums[index]);
				triple.add(nums[left]);
				triple.add(nums[right]);
				results.add(triple);
				left++;
				right--;
				while (left < right && nums[left] == nums[left - 1]) {
					left++;
				}
			}
		}
	}
}