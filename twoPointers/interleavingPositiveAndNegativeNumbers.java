public class Solution {
	public void rerange(int[] A) {
		if (A == null || A.length == 0) {
			return;
		}

		int left = 0, right = A.length - 1;
		while (left < right) {
			if (A[left] < 0) {
				left++;
				continue;
			}
			if (A[right] > 0) {
				right--;
				continue;
			}
			int tmp = A[left];
			A[left] = A[right];
			A[right] = tmp;
			left++;
			right--;
		}

		if (left > A.length - left) {
			interleave(A, 1, A.length - 1);
		} else if (left < A.length - left) {
			interleave(A, 0, A.length - 2);
		} else {
			interleave(A, 0, A.length - 1);
		}
	}

	private void interleave(int[] A, int start, int end) {
		while (start < end) {
			int tmp = A[start];
			A[start] = A[end];
			A[end] = tmp;
			start += 2;
			end -= 2;
		}
	}
}