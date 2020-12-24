/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
	public List<Integer> searchRange(TreeNode root, int k1, int k2) {
		List<Integer> result = new ArrayList<>();
		travel(root, k1, k2, result);
		return result;
	}

	private void travel(TreeNode root, int k1, int k2, List<Integer> result) {
		if (root == null) {
			return;
		}

		// pruning
		if (root.val > k1) {
			travel(root.left, k1, k2, result);
		}
		if (root.val >= k1 && root.val <= k2) {
			result.add(root.val);
		}
		if (root.val < k2) {
			travel(root.right, k1, k2, result);
		}
	}
}