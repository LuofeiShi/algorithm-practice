class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new LinkedList<>();
        
        // check edge cases
        if (arr == null || arr.length == 0) {
            return null;
        }
        // 1 <= k <= arr.length
        
        int index = firstIndex(arr, x);
        
        int start = index - 1;
        int end = index;
        for (int i = 0; i < k; i++) {
            if (start < 0) {
                result.add(arr[end++]);
            } else if (end >= arr.length) {
                result.add(0, arr[start--]);
            } else {
                // normal mode
                if (x - arr[start] <= arr[end] - x) {
                    result.add(0, arr[start--]);
                } else {
                    result.add(arr[end++]);
                }
            }
        }
        return result;
        
    }
    
    private int firstIndex(int[]arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (arr[start] >= target) {
            return start;
        }
        if (arr[end] >= target) {
            return end;
        }
        return arr.length;
    }
}