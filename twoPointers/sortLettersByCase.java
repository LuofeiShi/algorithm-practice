public Solution {
	public void sortLetters(char[] chars) {
		if (chars == null || chars.length < 2) {
			return;
		}

		int left = 0, right = chars.length - 1;
		while (left <= right) {
			while (left <= right 
				&& chars[left] >= 'a'
				&& chars[left] <= 'z') {
				left++;
			}
			while (left <= right
				&& chars[right] >= 'A'
				&& chars[left] <= 'Z') {
				right--;
			}
			if (left <= right) {
				char temp = chars[left];
				chars[left] = chars[right];
				chars[right] = temp;
				left++;
				right--;
			}
		}
	}
}