// A typical greedy problem.
// The overall strategy is very similar to the course schedule (without
// topological sort) with greedy algorithm: from left,  we want to find a
// fountains covers range as large as possible.
class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] arr = new int[n + 1];
        // get an array which represent the garden and each element is the range
        // of tap that covers longest position to the right.
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i] == 0) continue;
            // find the left position that current tap in ranges coverd.
            int left = Math.max(0, i - ranges[i]);
            // update the new array with the tap that covers most right
            // position.
            arr[left] = Math.max(arr[left], i + ranges[i]);
        }

        int end = 0, farCanReach = 0, cnt = 0;
        for (int i = 0; i < arr.length && end < n; end = farCanReach) {
            cnt++;
            // find a tap that covers the right most position
            while (i < arr.length && i <= end) {
                farCanReach = Math.max(farCanReach, arr[i++]);
            }
            // edge case: if we can't cover the whole garden, return -1.
            if (end == farCanReach) {
                return -1;
            }
        }

        return cnt;
    }
}
