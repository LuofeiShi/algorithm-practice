class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        
        dfs(result, n, 0, 0, "");
        return result;
    }
    
    private void dfs(List<String> result, int n, int left, int right, String cur) {
        if (cur.length() == 2 * n) {
            result.add(cur);
            return;
        }
        
        if (left < n) {
            dfs(result, n, left + 1, right, cur + "(");
        }
        if (right < left) {
            dfs(result, n, left, right + 1, cur + ")");
        }
    }
}
