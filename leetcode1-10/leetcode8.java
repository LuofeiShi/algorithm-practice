class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // delete all extra space
        int k = 0;
        while (k < s.length() && s.charAt(k) == ' ') {
            k++;
        }
        if (k == s.length()) {
            return 0;
        }
        
        // get the sign of the int
        int minus = 1;
        if (s.charAt(k) == '-') {
            minus = -1;
            k++;
        } else if (s.charAt(k) == '+') {
            k++;
        }
        
        int res = 0;
        while (k < s.length() && isDigit(s.charAt(k))) {
            int x = s.charAt(k) - '0';
            // check overflow
            if (minus > 0 && res > (Integer.MAX_VALUE - x) / 10) {
                return Integer.MAX_VALUE;
            } else if (minus < 0 && -res < (Integer.MIN_VALUE + x) / 10) {
                return Integer.MIN_VALUE;
            }
            if (-res * 10 - x == Integer.MIN_VALUE) {
                return  Integer.MIN_VALUE;
            }
            res = res * 10 + x;
            k++;
            if (res > Integer.MAX_VALUE) {
                break;
            }
        }
        
        return res * minus;
        
    }
    
    private boolean isDigit(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }
}
