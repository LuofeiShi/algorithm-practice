class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        
        // easy trace back/dfs problem.
        // enumerate all results by brute force searching.
        // The only problem here is the searching sequence.
        
        dfs(candidates, 0, target);
        return result;
    }
    
    private void dfs(int[] candidates, int index, int target) {
        if (target == 0) {
            // we need a deep copy here, or the path would change later
            // notice that the path is a pointer to a certain value in the memory
            // during the program, it points to the same address.
            List<Integer> cur = new ArrayList<>(path);
            result.add(cur);
            return;
        }
        
        if (index == candidates.length) {
            // we reach the end of the array, stop here
            return;
        }
        // for each element in the array, we can select once or multiple times
        // when the value is less than target
        for (int i = 0; candidates[index] * i <= target; i++) {
            dfs(candidates, index + 1, target - candidates[index] * i);
            path.add(candidates[index]);
        }
        
        for (int i = 0; candidates[index] * i <= target; i++) {
            path.remove(path.size() - 1);
        }
    }
}
