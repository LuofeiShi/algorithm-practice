class Solution {
    public int firstMissingPositive(int[] nums) {
        // check edge case
        if (nums == null || nums.length == 0) {
            return 1;
        }
        
        int index = 0;
        while (index < nums.length) {
            if (nums[index] > 0 && nums[index] < nums.length) {
                if (nums[index] != index+1 && nums[index] != nums[nums[index] - 1])
                    swap(nums, index, nums[index] - 1);
                else
                    index++;
            } else {
                index++;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
