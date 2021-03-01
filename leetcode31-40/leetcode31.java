class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        
        // permutation by single pass
        // search from the back
        // if the elements after current elements is decending, we won't change anything
        // we need to find the first decending point
        int k = nums.length - 1;
        while (k > 0 && nums[k - 1] >= nums[k]) k--;
        if (k <= 0) {
            reverse(nums, 0, nums.length - 1);
        } else {
            int t = k;
            while (t < nums.length && nums[t] > nums[k - 1]) t++;
            swap(nums, t-1, k-1);
            reverse(nums, k, nums.length - 1);
        }
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
