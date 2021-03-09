class Solution {
    public String countAndSay(int n) {
        String s = "1";
        
        for (int i = 0; i < n - 1; i++) {
          // Java is good at dealing with string in real world, but it is really verbose
          // to using StringBuilder on LeetCode for practice. Python, C, C++ have much easier
          // syntax to deal with string. And I think maybe I should use Python for the leetcode
          // in the future.
            StringBuilder t = new StringBuilder();
            for (int j = 0; j < s.length();) {
                int k = j + 1;
                while (k < s.length() && s.charAt(k) == s.charAt(j)) {
                    k++;
                }
                t.append(Integer.toString(k - j));

                t.append(Character.toString(s.charAt(j)));
                j = k;
            }
            s = t.toString();
        }
        return s;
    }
}
