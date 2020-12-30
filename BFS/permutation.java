class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        dfs(nums, new boolean[nums.length], new ArrayList<Integer>(), result);
        
        return result;
    }
    
    private void dfs(int[] nums,
                    boolean[] visited,
                    List<Integer> permutation,
                    List<List<Integer>> results) {
        if (nums.length == permutation.size()) {
            // deep copy
            results.add(new ArrayList<Integer>(permutation));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            
            permutation.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, permutation, results);
            visited[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    }
    
}