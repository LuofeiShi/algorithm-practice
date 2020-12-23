class ResultType {
	public boolean isBST;
	public TreeNode maxNode, minNode;
	public ResultType(boolean isBST) {
		this.isBST = isBST;
		this.maxNode = null;
		this.minNode = null;
	}
}

public class Solution {
	public boolean isValidBST(TreeNode node) {
		return divideConquer(root).isBST;
	}

	private ResultType divideConquer(TreeNode root) {
		if (root == null) {
			return new ResultType(true);
		}

		ResultType left = divideConquer(root.left);
		ResultType right = divideConquer(root.right);

		if (!left.isBST || !right.isBST) {
			return new ResultType(false);
		}

		if (left.maxNode != null && left.maxNode.val >= root.val) {
			return new ResultType(false);
		}

		if (right.maxNode != null && right.maxNode.val <= root.val) {
			return new ResultType(false);
		}

		// is bst
		ResultType result = new ResultType(true);
		result.minNode = left.minNode != null ? left.minNode : root;
		result.maxNode = right.maxNode != null ? right.maxNode : root;

		return result;
	}
}