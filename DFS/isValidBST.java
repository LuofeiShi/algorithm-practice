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

// Version 1: Divide and Conquer
class Solution {
    public boolean isValidBST(TreeNode root) {
        return divConq(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean divConq(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return divConq(root.left, min, Math.min(max, root.val))
            && divConq(root.right, Math.max(min, root.val), max);
    }
}


// Version 2: inorder traverse
public class Solution {
    int maxVal = Integer.MIN_VALUE;
    
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        boolean left = isValidBST(root.left);
        if (root.left != null) {
            if (root.val <= root.left.val) {
                return false;
            }
        }
        if ( root.val < maxVal) {
            return false;
        }
        maxVal = root.val > maxVal ? root.val : maxVal;
        if (root.right != null && root.val >= root.right.val) {
            return false;
        }
        boolean right = isValidBST(root.right);
        return left && right;
    }
}