class Solution {
    public int[] sortArrayByParity(int[] A) {
        if (A == null || A.length < 2) {
            return A;
        }
        
        int left = 0, right = A.length - 1;
        while (left <= right) {
            while (left <= right && A[left] % 2 == 0) {
                left++;
            }
            while (left <= right && A[right] % 2 == 1) {
                right--;
            }
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }
        return A;
    }
}
