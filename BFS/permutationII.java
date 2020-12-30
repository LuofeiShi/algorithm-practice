class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        
        bfs(result, nums, new boolean[nums.length], new ArrayList<Integer>());
        
        return result;
    }
    
    private void bfs(List<List<Integer>> result,
                    int[] nums,
                    boolean[] visited,
                    List<Integer> permutation) {
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<Integer>(permutation));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (i > 0  
                && nums[i] == nums[i - 1]
                && !visited[i - 1]) {
                continue;
            }
            if (visited[i]) {
                continue;
            }
            permutation.add(nums[i]);
            visited[i] = true;
            bfs(result, nums, visited, permutation);
            visited[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    }
}