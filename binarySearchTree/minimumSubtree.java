public class Solution {
	private TreeNode = null;
	private int subtreeSum = Integer.MAX_VALUE;

	public TreeNode findSubtree(TreeNode root) {
		helper(root);
		return subtree;
	}

	private int helper(TreeNode root) {
		if (root = null)
			return 0;

		int sum = helper(root.left) + helper(root.right) + root.val;

		if (sum < subtreeSum) {
			subtreeSum = sum;
			subtree = root;
		}

		return sum;
	}
}