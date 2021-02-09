class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        
        // reverse the given int
        long res = 0;
        int d = x;
        while (d != 0) {
            res = res * 10 + d % 10;
            d /= 10;
        }
        return res == x;
    }
}
