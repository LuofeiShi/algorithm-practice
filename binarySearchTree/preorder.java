public class Solution {
	// 1.递归的定义：返回以root为根的二叉树的preorder
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		traverse(root, result);
		return result;
	}

	private void traverse(TreeNode root, ArrayList<Integer> result) {
		if (root == null) {
			return;
		}

		result.add(root.val);
		traverse(root.left, result);
		traverse(root.right, result);
	}
}