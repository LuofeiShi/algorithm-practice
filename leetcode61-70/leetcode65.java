// is this problem made for QA position? Can't believe it... fail more than 10 times on this
class Solution {
    public boolean isNumber(String s) {
        // 1. trim the whitespace on two sides of the string
        int l = 0, r = s.length() - 1;
        while (l <= r && s.charAt(l) == ' ') l++;
        while (r >= l && s.charAt(r) == ' ') r--;
        if (l > r) return false;
        // check '+' and '-'
        if (s.charAt(0) == '+' || s.charAt(0) == '-') s = s.substring(1);
        if (s.length() == 0) return false;
        // check '.' and 'e' at the beginning of the string
        if (s.charAt(0) == '.' && (s.length() == 1 || s.charAt(1) == 'e' || s.charAt(1) == 'E')) return false;
        int dot = 0, e = 0;
        for (int i = 0; i < s.length();i++) {
            if (s.charAt(i) == '.') {
                if (dot > 0 || e > 0) return false;
                dot++;
            } else if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                if (i == 0 || i + 1 == s.length() || e > 0) return false;
                if (s.charAt(i + 1) == '+' || s.charAt(i + 1) == '-') {
                    if (i + 2 == s.length()) return false;
                    i++;
                }
                e++;
            } else if (s.charAt(i) < '0' || s.charAt(i) > '9') return false;
        }
        return true;
    }
}
