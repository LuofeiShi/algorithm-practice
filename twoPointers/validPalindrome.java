public class Solution {
	public boolean isPalindrome(Stirng s) {
		if (s == null || s.length() == 0) {
			return true;
		}

		int front = 0;
		int end = s.length() - 1;
		while (front < end) {
			while (front < s.length() && !isvalid(s.charAt(front))) {
				front++;
			}
			if (front == s.length()) {
				return true;
			}

			while (end >= 0 && !isvalid(s.charAt(end))) {
				end--;
			}
			if (Character.toLowerCase(s.charAt(front)) != Character.toLowerCase(s.charAt(end))) {
				break;
			} else {
				front++;
				end--;
			}
		}
		return end <= front;
	}

	private boolean  isvalid(char c) {
		return Character.isLetter(c) || Character.isDigit(c);
	}
}