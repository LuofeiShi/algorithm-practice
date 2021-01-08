class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lenA = nums1.length, lenB = nums2.length;
        if (lenA > lenB) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        if (lenA == 0) {
            return ((double) nums2[(lenB - 1) / 2] + (double) nums2[lenB / 2]) / 2; // cover odd and even cases
        }
        
        int len = lenA + lenB;
        int A_startK = 0, A_endK = lenA;
        int cutA, cutB;
        while (A_startK <= A_endK) {
            cutA = (A_endK + A_startK) / 2;
            cutB = (len + 1) / 2 - cutA;
            
            double L1 = (cutA == 0) ? Integer.MIN_VALUE : nums1[cutA - 1];
            double L2 = (cutB == 0) ? Integer.MIN_VALUE : nums2[cutB - 1];
            double R1 = (cutA == lenA) ? Integer.MAX_VALUE : nums1[cutA];
            double R2 = (cutB == lenB) ? Integer.MAX_VALUE : nums2[cutB];
            
            if (L1 > R2) {
                A_endK = cutA - 1;
            } else if (L2 > R1) {
                A_startK = cutA + 1;
            } else {
                if (len % 2 == 0) {
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
                } else {
                    return Math.max(L1, L2);
                }
            }
        }
        return -1;
    }
}