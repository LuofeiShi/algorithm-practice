class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        
        while (right < nums.length) {
            if (nums[right] != 0) {
                if (left != right) {
                    nums[left] = nums[right];
                }
                left++;
            }
            right++;
        }
        
        while (left < nums.length) {
            if (nums[left] != 0) {
                nums[left] = 0;
            }
            left++;
        }
    }
}

// version 2: two pointers
public class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }
}