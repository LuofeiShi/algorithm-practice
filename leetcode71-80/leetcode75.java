class Solution {
    public void sortColors(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        // three pointers
        int zero, one, two;
        zero = 0;
        two = nums.length - 1;
        one = two;
        while (zero <= two) {
            if (nums[zero] == 2) {
                swap(nums, zero, two);
                two--;
            } else if (nums[zero] == 0) {
                if (one < zero) {
                    swap(nums, zero, one);
                    one++;
                }
                zero++;
            } else {
                // nums[zero] == 1
                one = Math.min(one, zero);
                zero++;
            }
        }
    }
    
    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
