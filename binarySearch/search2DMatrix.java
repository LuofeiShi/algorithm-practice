class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // row = idx // n and col = idx % n
        int m = matrix.length;
        if (m == 0)
            return false;
        int n = matrix[0].length;
        
        // regular binary search
        int start = 0, end = m * n - 1;
        int pivotIdx, pivotElement;
        while (start <= end) {
            pivotIdx = start + (end - start) / 2;
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (target == pivotElement) {
                return true;
            } else if (target < pivotElement) {
                end = pivotIdx - 1;
            } else {
                start = pivotIdx + 1;
            }
        }
        return false;
    }
}