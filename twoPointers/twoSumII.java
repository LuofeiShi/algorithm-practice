// Given an array of integers that is already sorted in ascending order, 
// find two numbers such that they add up to a specific target number.

// The function twoSum should return indices of the two numbers such that 
// they add up to the target, where index1 must be less than index2.

// Note:

// Your returned answers (both index1 and index2) are not zero-based.
// You may assume that each input would have exactly one solution and 
// you may not use the same element twice.
public class Solution {
	public int[] twoSum(int[] nums, int target) {
		if (nums == null || nums.length < 2) {
			return null;
		}

		int start = 0, end = nums.length - 1;
		while (start < end) {
			if (nums[start] + nums[end] == target) {
				int[] pair = new int[2];
				pair[0] = start + 1;
				pair[1] = end + 1;
				return pair;
			} else if (nums[start] + nums[end] < target) {
				start++;
			} else {
				end--;
			}
		}

		// didn't find any result
		return null;
	}
}