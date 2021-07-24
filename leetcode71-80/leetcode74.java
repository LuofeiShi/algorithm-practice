class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // row = idx//n and col = idx%n
        // treat the matrix as a flat array
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        
        // binary search
        int l = 0, r = m * n - 1;
        int mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            int cur = matrix[mid / n][mid % n];
            if (target == cur) {
                return true;
            } else if (target < cur) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
}
