class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        
        // find the descending part from end
        int i = nums.length - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) {
            i--;
        }
        invert(nums, i, nums.length - 1);
        if (i == 0) {
            return;
        }
        int j = i;
        while (nums[j] <= nums[i - 1] && j < nums.length - 1) {
            j++;
        }
        swap(nums, i - 1, j);
        return;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void invert(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}