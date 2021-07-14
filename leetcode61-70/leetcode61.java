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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        // count the number of nodes
        int size = 0;
        ListNode cursor = head;
        while (cursor != null) {
            size++;
            cursor = cursor.next;
        }
        // valid k
        k = k % size;
        if (k == 0) return head;
        k = size - k;
        cursor = head;
        ListNode last = null;
        while (k-- > 0) {
            last = cursor;
            cursor = cursor.next;
        }
        ListNode newHead = cursor;
        last.next = null;
        cursor = newHead;
        while (cursor.next != null) cursor = cursor.next;
        cursor.next = head;
        return newHead;
    }
}
