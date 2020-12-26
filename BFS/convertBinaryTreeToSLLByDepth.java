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
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @return a lists of linked list
     */
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        // Write your code here
        List<ListNode> result = new ArrayList<>();
        if (root == null)
            return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode level = new ListNode(0);
            ListNode pre = level;
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                if (head.left != null)
                    queue.offer(head.left);
                if (head.right != null)
                    queue.offer(head.right);
                ListNode headNode = new ListNode(head.val);
                pre.next = headNode;
                pre = headNode;
            }
            result.add(level.next);
        }
        return result;
    }
}