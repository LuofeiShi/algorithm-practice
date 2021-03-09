class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, target);
        return result;
    }
    
    private void dfs(int[] c, int index, int target) {
        if (target == 0) {
            List<Integer> cur = new ArrayList<>(path);
            result.add(cur);
            return;
        }
        
        if (index == c.length) {
            // can't find valid combination in current path
            return;
        }
        
        // count the number of current index value 
        int k = index + 1;
        while (k < c.length && c[k] == c[index]) {
            k++;
        }
        
        int cnt = k - index;
        
        for (int i = 0; c[index] * i <= target && i <= cnt; i++) {
            dfs(c, k, target - c[index] * i);
            path.add(c[index]);
        }
        for (int i = 0; c[index] * i <= target && i <= cnt; i++) {
            path.remove(path.size() - 1);
        }
    }
}
