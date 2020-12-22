/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private class ResultType {
        public double sum;
        public int size;
        public ResultType(double sum, int size) {
            this.sum = sum;
            this.size = size;
        }
    }
    
    private TreeNode maxAveSubtree = null;
    private ResultType subtreeResult = null;
    
    public double maximumAverageSubtree(TreeNode root) {
        helper(root);
        double result = subtreeResult.sum / subtreeResult.size;
        return result;
    }
    
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        ResultType rootResult = new ResultType(
            left.sum + right.sum + root.val,
            left.size + right.size + 1
        );
        
        // if (a/b < c/d) {
        //  // if (a * c < b * d)
        // }
        
        if (maxAveSubtree == null 
            || subtreeResult.sum * rootResult.size < rootResult.sum * subtreeResult.size) {
            maxAveSubtree = root;
            subtreeResult = rootResult;
        }
        return rootResult;
    }
}