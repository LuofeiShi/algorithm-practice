class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        int n = haystack.length();
        int m = needle.length();
        haystack = " " + haystack;
        needle = " " + needle;
        
        // KMP: next[] records the longest prefix and suffix
        int[] next = new int[m + 1];
        for (int i = 2, j = 0; i <= m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j + 1)) {
                j = next[j];
            }
            if (needle.charAt(i) == needle.charAt(j + 1)) {
                j++;
            }
            
            next[i] = j;
        }
        
        for (int i = 1, j = 0; i <= n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j + 1)) {
                j = next[j];
            }
            
            if (haystack.charAt(i) == needle.charAt(j + 1)) {
                j++;
            }
            if (j == m) {
                return i - m;
            }
        }
        
        return -1;
        
    }
}
