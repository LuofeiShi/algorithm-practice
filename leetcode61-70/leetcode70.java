class Solution {
    public int climbStairs(int n) {
        // using Fibonacci number
        int a = 1, b = 1;
        while (--n > 0) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
