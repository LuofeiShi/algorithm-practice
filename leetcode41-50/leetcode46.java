class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // a typical dfs enumerate question.
        List<List<Integer>> results = new ArrayList<>();
        
        dfs(nums, results, 0, new ArrayList<>());
        return results;
    }
    
    private void dfs(int[] nums, List<List<Integer>>results, int index, List<Integer> cur) {
        // reach the end of the nums, append current sequence into the results
        if (index >= nums.length) {
            List<Integer> temp = new ArrayList<>(cur);
            results.add(temp);
            return;
        }
        // enumerate every permutation
        for (int i = 0; i < nums.length; i ++) {
            if (cur.contains(nums[i])) {
                continue;
            }
            // insert current element, and then remove it from current sequence to get all permutation
            cur.add(nums[i]);
            dfs(nums, results, index + 1, cur);
            cur.remove(index);
        }
    }
}
