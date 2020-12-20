class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[start]) {
                // the mid is located in the first half of the rotated array
                if (target >= nums[start] && target < nums[mid]) {
                    // situation 1: target is in the first half
                    end = mid - 1;
                } else {
                    // situation 2: target is in the second half
                    // or target is larger than nums[mid]
                    start = mid + 1;
                }
            } else {
                // the mid is located in the second half of the rotated array
                if (target <= nums[end] && target > nums[mid]) {
                    // target is in the first half
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}