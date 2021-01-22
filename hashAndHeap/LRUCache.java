class LRUCache {
	private class ListNode {
		private int key, val;
		private ListNode next;

		private ListNode(int key, int val) {
			this.key = key;
			this.val = val;
			this.next = null;
		}
	}

	private int capacity;
	private int size;
	private ListNode dummy;
	private ListNode tail;
	private Map<Integer, ListNode> keyToPrev;

	// Least Recently used cache
	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.keyToPrev = new HashMap<>();
		this.dummy = new ListNode(0, 0);
		this.tail = this.dummy;
	}

	private void moveToTail(int key) {
		ListNode prev = keyToPrev.get(key);
		ListNode curt = prev.next;

		if (tail == curt) {
			return;
		}

		prev.next = prev.next.next;
		tail.next = curt;
		curt.next = null;

		if (prev.next != null) {
			keyToPrev.put(prev.next.key, prev);
		}
		keyToPrev.put(curt.key, tail);

		tail = curt;
	}

	public int get(int key) {
		if (!keyToPrev.containsKey(key)) {
			return -1;
		}

		moveToTail(key);

		// the key has been moved to the end
		return tail.val;
	}

	public void put(int key, int value) {
		if (get(key) != -1) {
			ListNode prev = keyToPrev.get(key);
			prev.next.val = value;
			return;
		}

		if (size < capacity) {
			size++;
			ListNode curt = new ListNode(key, value);
			tail.next = curt;
			keyToPrev.put(key, tail);

			tail = curt;
			return;
		}

		// replace the first node with the new key, value
		ListNode first = dummy.next;
		keyToPrev.remove(first.key);

		first.key = key;
		first.val = value;
		keyToPrev.put(key, dummy);

		moveToTail(key);
	}
}