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
    
    private static final int NOT_BALANCE = -1;

    public boolean isBalanced(TreeNode root) {        
        // a tree is balanced if the depth of all leaves are within 1
        return maxDepth(root) != NOT_BALANCE;
    }
    
    private int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left == NOT_BALANCE || right == NOT_BALANCE 
            || Math.abs(left - right) > 1) {
            return NOT_BALANCE;
        }
        return Math.max(left, right) + 1;
    }
}