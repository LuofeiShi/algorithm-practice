class Solution {
    public void rotate(int[][] matrix) {
        // first we flip the matrix on diagonal
        // then we flip the matrix from left to right
        /*
        *   1 2 3               1 4 7               7 4 1
        *   4 5 6       ->      2 5 8       ->      8 5 2
        *   7 8 9               3 6 9               9 6 3
        */
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0, k = n - 1; j < k; j++, k--) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
            }
        }
    }

}
