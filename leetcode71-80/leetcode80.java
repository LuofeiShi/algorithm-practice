class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int x : nums) {
            if (k < 2 || (nums[k - 1] != x || nums[k - 2] != x))
                nums[k++] = x;
        }
        return k;
    }
}
