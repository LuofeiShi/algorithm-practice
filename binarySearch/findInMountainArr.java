/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();
        // find the peak first
        int peak = findPeak(target, mountainArr, len);
        int result = binarySearchLeft(target, mountainArr, 0, peak - 1);
        if (result == -1) {
            result = binarySearchRight(target, mountainArr, peak, len - 1);
        }
        return result;
    }
    
    // return the peak's position of the mountain arr
    private int findPeak(int target, MountainArray mountainArr, int len) {
        int start = 0, end = len - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int midValue = mountainArr.get(mid);
            int rightValue = mountainArr.get(mid+1);
            if (midValue < rightValue) {
                // peak is on the right
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
    
    private int binarySearchLeft(int target, MountainArray mountainArr, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midValue = mountainArr.get(mid);
            if (midValue == target) {
                return mid;
            } else if (midValue < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
    
        private int binarySearchRight(int target, MountainArray mountainArr, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midValue = mountainArr.get(mid);
            if (midValue == target) {
                return mid;
            } else if (midValue < target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
    
}