class Solution {
    // to finish the algorithm in space, we use the first row and col to store
    // if the following cols or rows have 0s.
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        int n = matrix.length, m = matrix[0].length;
        
        // use r0 and c0 to record the appearance of 0 in first row and column
        int r0 = 1, c0 = 1;
        for (int i = 0; i < m; i++) {
            if (matrix[0][i] == 0) {
                r0 = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                c0 = 0;
            }
        }
        
        // using the first row and col to record the appearance of 0 in each row and col
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        // change according cell to 0
        for (int i = 1; i < n; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < m; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        for (int i = 1; i < m; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        
        // change the first row and col
        if (r0 == 0) {
            for (int i = 0; i < m; i++) {
                matrix[0][i] = 0;
            }
        }
        if (c0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
