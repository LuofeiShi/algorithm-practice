/**
 * Leetcode #702. Search in a Sorted Array of Unknown Size
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int i = 1;

        
        // find a estimate end for binary search
        // the idea is pretty much like dynamic array (vector)
        // exponential backoff
        while (reader.get(i) < target) {
            i = i * 2;
        }
        
        int start = i / 2, end = i;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (reader.get(mid) < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (reader.get(start) == target)
            return start;
        
        if (reader.get(end) == target)
            return end;
        
        return -1;
    }
}