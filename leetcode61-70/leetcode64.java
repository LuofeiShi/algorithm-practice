class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;
        
        int[][] f = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                f[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) f[i][j] = grid[i][j];
                else {
                    if (i != 0) f[i][j] = Math.min(f[i][j], f[i - 1][j]) + grid[i][j];
                    if (j != 0) f[i][j] = Math.min(f[i][j], f[i][j - 1] + grid[i][j]);
                }
            }
        }
        
        return f[n - 1][m - 1];
    }
}
