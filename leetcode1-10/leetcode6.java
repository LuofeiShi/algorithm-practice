class Solution {
    public String convert(String s, int n) {
        if (s == null || s.length() <= n || n == 1) {
            return s;
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1) {
                for (int j = i; j < s.length(); j += 2 * n - 2)
                    result.append(s.charAt(j));
            } else {
                for (int j = i, k = 2*n - 2 - i; j < s.length() || k < s.length(); 
                     j += 2*n - 2, k += 2*n - 2) {
                    if (j < s.length()) result.append(s.charAt(j));
                    if (k < s.length()) result.append(s.charAt(k));
                }
            }
        }
        return result.toString();
    }
}
