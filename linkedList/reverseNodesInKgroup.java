Class Solution {
	public ListNode reverseGroup(ListNode head, int k) {
		// using dummy node to reduce the complexity
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode prev = dummy;
		while (prev != null) {
			prev = reversesNextNodes(prev, k);
		}

		return dummy.next;
	}

	private ListNode reverseNextNodes(ListNode head, int k) {
		// find the k-th node
		ListNode n1 = head.next;	// the real first node in the k-group
		ListNode cur = head;

		for (int i = 0; i < k; i++) {
			if (cur == null) {		// edge case: doesn't reach k steps, do nothing
				return null;
			}
			cur = cur.next;
		}

		ListNode nk = cur;
		ListNode nkplus = cur.next;	// the next node after k-group

		// reverse k nodes
		ListNode prev = head;		// prev = dummy node
		cur = head.next;

		while (cur != null) {
			ListNode temp = cur.next;
			cur.next = prev;
			prev = cur;
			cur = temp;
		}

		head.next = nk;
		n1.next = nkplus;

		return n1;
	}
}