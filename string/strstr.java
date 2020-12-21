class Solution {
    private int BASE = 100000;
    
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null)
            return -1;

        int m = needle.length();
        if (m == 0) {
            return 0;
        }
        
        // 31 ^ m
        int power = 1;
        for (int i = 0; i < m; i++) {
            power = (power * 31) % BASE;
        }
        
        int targetCode = 0;
        for (int i = 0; i < m; i++) {
            targetCode = (targetCode * 31 + needle.charAt(i)) % BASE;
        }
        
        int hashCode = 0;
        for (int i = 0; i < haystack.length(); i++) {
            // abc + d
            hashCode = (hashCode * 31 + haystack.charAt(i)) % BASE;
            if (i < m - 1) {
                continue;
            }
            // sliding window
            if (i >= m) {
                hashCode = hashCode - (haystack.charAt(i - m) * power) % BASE;
                if (hashCode < 0)
                    hashCode += BASE;
            }
                    // double check the string
            if (hashCode == targetCode) {
                if (haystack.substring(i - m + 1, i + 1).equals(needle)) {
                    return i - m + 1;
                }
            }
        }
        

        return -1;
    }
}