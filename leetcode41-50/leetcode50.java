class Solution {
    public double myPow(double x, int n) {
        // fast power algorithm
        boolean is_minus = n < 0;
        double res = 1;
        // iterate fast power solution, the time complexity is O(logn)
        // treat the given n as a binary number, and the digit with "1"
        // means we need to multiply a factor
        for (long k = Math.abs((long) n); k > 0; k >>= 1) {
            // multiply the factor if current binary ones place is 1
            if ((k & 1) > 0) res *= x;
            // pre-calculate next factor
            x *= x;
        }
        if (is_minus) res = 1 / res;
        return res;
    }
}
