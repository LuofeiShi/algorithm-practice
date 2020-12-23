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
// iterate version
public class Solution {
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		ArrayList<Integer> result = new ArrayList<>();
		TreeNode curt = root;

		while (curt != null || !stack.empty()) {
			while (curt != null) {
				stack.add(curt);
				curt = curt.left;
			}
			curt = stack.pop();
			result.add(curt.val);
			curt = curt.right;
		}

		return result;
	}
}