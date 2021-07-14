class Solution {
    public int[] plusOne(int[] digits) {
        
        int overtake = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int cur = digits[i];
            cur += overtake;
            if (cur > 9) {
                overtake = cur / 10;
                cur = cur % 10;
                digits[i] = cur;
            } else {
                overtake = 0;
                digits[i] = cur;
                break;
            }
        }
        // check if we need one more element in front of the array
        if (overtake == 0) {
            return digits;
        } else {
            int[] res = new int[digits.length + 1];
            res[0] = overtake;
            for (int i = 1; i <= digits.length; i++) {
                res[i] = digits[i - 1];
            }
            return res;
        }
    }
}
