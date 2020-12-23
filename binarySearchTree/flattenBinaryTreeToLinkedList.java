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
	private TreeNode last;

	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}

		// connect the last node to the current root
		if (last != null) {
			last.left = null;
			last.right = root;
		}

		// do preorder traverse
		last = root;
		TreeNode right = root.right;
		flatten(root.left);
		flatten(right);
	}
}