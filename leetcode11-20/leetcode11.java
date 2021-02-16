class Solution {
    public int maxArea(int[] height) {
        // edge cases
        if (height == null || height.length == 0) {
            return 0;
        }
        
        // two pointers
        int left = 0, right = height.length - 1;
        long maxArea = 0;
        while (left < right) {            
            long area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(area, maxArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }

        }
        return (int)maxArea;
    }
}
