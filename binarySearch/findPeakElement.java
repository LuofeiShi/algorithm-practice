class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // we have four situation here
            // first two situations: on a downhill / bottom
            if (nums[mid - 1] > nums[mid]) {
                end = mid;
            } else if (nums[mid] < nums[mid + 1]) {
                // third situation: on a uphill
                start = mid;
            } else {
                // fourth situation: on the peak
                end = mid;
            }
        }
        
        if (nums[start] < nums[end]) {
            return end;
        } else {
            return start;
        }
    }
}