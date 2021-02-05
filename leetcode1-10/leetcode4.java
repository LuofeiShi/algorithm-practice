class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int tot = nums1.length + nums2.length;
        if (tot % 2 == 0) {
            int left = find(nums1, 0, nums2, 0, tot / 2);
            int right = find(nums1, 0, nums2, 0, tot / 2 + 1);
            return (left + right) / 2.0;
        } else {
            return find(nums1, 0, nums2, 0, tot / 2 + 1);
        }
    }
    
    private int find(int[] nums1, int i, int[] nums2, int j, int k) {
        if (nums1.length - i > nums2.length - j) {
            return find(nums2, j, nums1, i, k);
        }
        // edge cases
        if (k == 1) {
            if (nums1.length == i) {    // empty
                return nums2[j];
            } else {
                return Math.min(nums1[i], nums2[j]);
            }
        }
        if (nums1.length == i) {
            return nums2[j + k - 1];
        }
        
        // normal case
        int si = Math.min(nums1.length, i + k / 2), sj = j + k - k / 2;
        if (nums1[si - 1] > nums2[sj - 1]) {
            return find(nums1, i, nums2, sj, k - (sj - j));
        } else {
            return find(nums1, si, nums2, j, k - (si - i));
        }
    }
}
