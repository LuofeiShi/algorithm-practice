class Solution {
    public boolean isMatch(String s, String p) {
        // a typical dp question.
        int n = s.length();
        int m = p.length();
        s = " " + s;
        p = " " + p;
        boolean[][] f = new boolean[n+1][m+1]; // init with false
        f[0][0] = true; // two empty string is matched
        
        // start our dp. Bottom up strategy here.
        // i could start with 0, since the '*' might match a zero string
        for (int i = 0; i <= n; i++) {
            // j should start from 1, since the string s will never match a empty string p
            for (int j = 1; j <= m; j++) {
                if (p.charAt(j) == '*') {
                    // the key of this question here. Notice that f[i - 1][j] is equal to
                    // the last part of f[i][j].
                    f[i][j] = f[i][j-1] || (i > 0 && f[i - 1][j]);
                } else {
                    f[i][j] = (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') && i > 0 && f[i-1][j-1];
                }
            }
        }
        
        return f[n][m];
    }
}
