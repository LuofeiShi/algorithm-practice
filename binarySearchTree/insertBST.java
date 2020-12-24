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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null) {
            if (cur.val > val) {
                pre = cur;
                cur = cur.left;
            } else {
                pre = cur;
                cur = cur.right;
            }
        }
        if (val < pre.val) {
            cur = new TreeNode(val);
            pre.left = cur;
        } else {
            cur = new TreeNode(val);
            pre.right = cur;
        }
        return root;
        
    }
}