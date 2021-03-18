class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);  // to guarantee that we won't make duplicate results
        boolean[] visited = new boolean[nums.length];
        dfs(nums, results, 0, new ArrayList<>(), visited);
        return results;
    }
    
    private void dfs(int[] nums, List<List<Integer>> results, int index, List<Integer> cur, boolean[] visited) {
        // reach the end of nums
        if (index >= nums.length) {
            List<Integer> temp = new ArrayList<>(cur);  // avoid shallow copy
            results.add(temp);
            return;
        }
        // using the visited[] array to check if the previous element with same value has been visited.
        // if not, it means we have do that in other permutation, and we don't want to repeat ourselves.
        // if yes, that means current nums[i] could be placed on current location in the permutation.
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i-1] && !visited[i-1]) {
                continue;
            }
            cur.add(nums[i]);
            visited[i] = true;
            dfs(nums, results, index + 1, cur, visited);
            cur.remove(index);
            visited[i] = false;
        }
    }
}
