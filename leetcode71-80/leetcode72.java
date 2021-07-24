class Solution {
    public int minDistance(String word1, String word2) {
        // three options:
        // 1. Insert a character
        // 2. Delete a character
        // 3. Replace a character
        // This can be solved by dp. It is a variation of longest sub sequece.
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        // dp[i][j] represents the edit distance between word1[1...i] to word2[1...j]
        // thus, we can compute dp[i][j] from dp[i-1][j] and dp[i][j-1]
        if (n * m == 0) {   // edge case: when one of the string is empty, return the other's length
            return n + m;
        }
        // init boundaries
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            dp[0][j] = j;
        }
        // fill in the dp table
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int left = dp[i - 1][j] + 1;
                int down = dp[i][j - 1] + 1;
                int left_down = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    left_down += 1;
                }
                dp[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return dp[n][m];
    }
}
