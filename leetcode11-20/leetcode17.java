class Solution {
    private List<String> results = new ArrayList<>();

    private String[] strs = new String[]{"", "", "abc", "def", "ghi", "jkl", 
                                  "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return results;
        }
        // DFS problem: recursion
        dfs(digits, 0, "");
        return results;
    }
    
    private void dfs(String digits, int index, String current) {
        if (index == digits.length()) {
            results.add(current);
            return;
        }
        int position = digits.charAt(index) - '0';
        for (int i = 0; i < strs[position].length(); i++) {
            StringBuilder sb = new StringBuilder(current);
            sb.append(strs[position].charAt(i));
            dfs(digits, index + 1, sb.toString());
        }
        return;
    }
}
