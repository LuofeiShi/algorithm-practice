class Solution {
    public int jump(int[] nums) {
        // a very tricky solution
        // the f(j) is monotonic
        int[] dp = new int[nums.length];
        
        // i start from 1: i represents a current end point
        // j start from 0: j represents a current start point
        // for each i, we want to find a best solution
        for (int i = 1, j = 0; i < nums.length; i++){
            // for each i, we need to find a coresponding j
            while (j + nums[j] < i) j++;
            dp[i] = dp[j] + 1;    // coresponding j with 1 jump.
        }
        
        return dp[nums.length - 1];
    }
}
