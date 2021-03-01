class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        Stack<Integer> stk = new Stack<>();
        
        int res = 0;
        for (int i = 0, start = -1; i < s.length(); i++) {
            if (s.charAt(i) == '(') stk.push(i);
            else {
                if (!stk.isEmpty()) {
                    stk.pop();
                    if (!stk.isEmpty()) {
                        res = Math.max(res, i - stk.peek());
                    } else {
                        res = Math.max(res, i - start);
                    }
                } else {
                    start = i;
                }
            }
        }
        return res;
    }
}
