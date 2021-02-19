/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // find the length of linked list
        int len = 0;
        ListNode cur = dummy;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        cur = dummy;
        for (int i = 0; i < len - n - 1; i++) {
            cur = cur.next;
        }
        if (cur.next == null) {
            return dummy.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }
}
