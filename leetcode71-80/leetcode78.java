class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrace(res, new ArrayList<>(), 0, nums);
        return res;
    }
    
    private void backtrace(List<List<Integer>> res, List<Integer> cur, int index, int[] nums) {
        res.add(new ArrayList<>(cur));
        
        for (int i = index; i < nums.length; i++) {
            cur.add(nums[i]);
            backtrace(res, cur, i + 1, nums);
            cur.remove(cur.size() - 1);
        }
    }
}
