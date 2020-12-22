public class Solution {
	public ArrayList<Integer> preorderTraversal(Treenode, root) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		if (root == null) {
			return result;
		}

		ArrayList<Integer> left = preorderTraversal(root.left);
		ArrayList<Integer> right = preorderTraversal(root.right);

		result.add(root.val);
		result.addAll(left);
		result.addAll(right);
		return result;
	}
}