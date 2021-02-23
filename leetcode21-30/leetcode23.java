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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        // hash table and priority queue
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new NodeComparator());
        for (ListNode node : lists) {
            if (node == null) {
                continue;
            }
            pq.add(node);
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            cur.next = pq.poll();
            cur = cur.next;
            if (cur.next != null) {
                pq.add(cur.next);
                cur.next = null;
            }
        }
        return dummy.next;
    }
    
    class NodeComparator implements Comparator<ListNode> {
        public int compare(ListNode n1, ListNode n2) {
            if (n1.val > n2.val) {
                return 1;
            } else if (n1.val == n2.val) {
                return 0;
            } else {
                return -1;
            }
        } 
    }
}
