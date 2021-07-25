class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(n, k, 1, ans, path);
        return ans;
    }
    
    private void dfs(int n, int k, int start, List<List<Integer>> ans, List<Integer> path) {
        if (k == 0) {
            List<Integer> temp = new ArrayList<>(path);
            ans.add(temp);
            return;
        }
        
        for (int i = start; i <= n; i++) {
            path.add(i);
            dfs(n, k-1, i+1, ans, path);
            path.remove(path.size() - 1);
        }
    }
}
